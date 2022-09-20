package UseCases.Command.Ventas.Editar;

import Factories.IPagoFactory;
import Factories.IVentaFactory;
import Model.Pagos.Pago;
import Model.Ventas.Venta;
import Repositories.IPagoRepository;
import Repositories.IUnitOfWork;
import Repositories.IVentaRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class EditarVentaHandler
  implements RequestHandler<EditarVentaCommand, Venta> {

  private IVentaFactory _ventaFactory;
  private IVentaRepository _ventaRepository;
  private IUnitOfWork _unitOfWork;

  public EditarVentaHandler(
    IVentaFactory ventaFactory,
    IVentaRepository ventaRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._ventaFactory = ventaFactory;
    this._ventaRepository = ventaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Venta handle(EditarVentaCommand request) throws Exception {
    Venta venta = _ventaRepository.FindByKey(request.venta.key);
    if (venta == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "venta no encontrada");
    }
    venta.nombre = request.venta.nombre;
    // venta.estadoVenta = request.venta.estadoVenta;

    _ventaRepository.Update(venta);

    return venta;
  }
}
