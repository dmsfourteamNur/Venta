package UseCases.Command.Ventas.Crear;

import java.util.UUID;

import Factories.IVentaFactory;
import Model.Ventas.Venta;
import Model.Vuelo.Tarifa;
import Model.Vuelo.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVentaRepository;
import Repositories.IVueloRepository;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;

public class CrearVentaHandler
    implements RequestHandler<CrearVentaCommand, UUID> {

  private IVentaFactory _ventaFactory;
  private IVentaRepository _ventaRepository;
  private IVueloRepository _vueloRepository;
  private IUnitOfWork _unitOfWork;

  public CrearVentaHandler(
      IVentaFactory ventaFactory,
      IVentaRepository ventaRepository,
      IVueloRepository vueloRepository,
      IUnitOfWork _unitOfWork) {
    this._ventaFactory = ventaFactory;
    this._ventaRepository = ventaRepository;
    this._vueloRepository = vueloRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(CrearVentaCommand request) throws Exception {
    Vuelo vuelo = _vueloRepository.FindByKey(request.data.keyVuelo);
    if (vuelo == null)
      throw new HttpException(HttpStatus.BAD_GATEWAY, "No existe el vuelo");

    Tarifa tarifa = vuelo.getTarifas().stream().filter(o -> o.key.equals(request.data.keyTarifa)).findAny()
        .orElse(null);
    if (tarifa == null)
      throw new HttpException(HttpStatus.BAD_GATEWAY, "No existe la tarifa en el vuelo");

    // TODO: validar que no pueda comprar la misma persona en un vuelo.

    Venta venta_obj = _ventaRepository.GetAll().stream()
        .filter(o -> (o.dni.equals(request.data.dni) && o.keyVuelo.equals(vuelo.key))).findAny().orElse(null);

    if (venta_obj != null)
      throw new HttpException(HttpStatus.BAD_GATEWAY, "El dni ya cuanta con un ticket en este vuelo");

    Venta venta = _ventaFactory.Create(request.data.nombre, request.data.apellido, request.data.dni,
        request.data.keyVuelo, request.data.keyTarifa, tarifa.getPrecio());
    venta.eventCreado();
    _ventaRepository.Create(venta);
    _unitOfWork.commit();
    return venta.key;
  }
}
