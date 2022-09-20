package UseCases.Command.Ventas.Crear;

import Factories.IVentaFactory;
import Model.Ventas.Venta;
import Repositories.IUnitOfWork;
import Repositories.IVentaRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;

public class CrearVentaHandler
    implements RequestHandler<CrearVentaCommand, Venta> {

  private IVentaFactory _ventaFactory;
  private IVentaRepository _ventaRepository;
  private IUnitOfWork _unitOfWork;

  public CrearVentaHandler(
      IVentaFactory ventaFactory,
      IVentaRepository ventaRepository,
      IUnitOfWork _unitOfWork) {
    this._ventaFactory = ventaFactory;
    this._ventaRepository = ventaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Venta handle(CrearVentaCommand request) throws Exception {
    Venta venta = _ventaFactory.Create(request.data.nombre, request.data.apellido, request.data.dni,
        request.data.keyVuelo, 1);
    venta.eventCreado();
    _ventaRepository.Create(venta);
    _unitOfWork.commit();
    return venta;
  }
}
