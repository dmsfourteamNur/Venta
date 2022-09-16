package UseCases.Command.Ventas.Editar;

import Factories.IPagoFactory;
import Factories.IVentaFactory;
import Model.Pagos.Pago;
import Model.Ventas.Venta;
import Repositories.IPagoRepository;
import Repositories.IUnitOfWork;
import Repositories.IVentaRepository;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

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
  public Venta handle(EditarVentaCommand request) throws HttpException {
    Venta venta = _ventaRepository.FindByKey(request.venta.key);
    if (venta == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "venta no encontrada");
    }
    venta.descripcion = request.venta.descripcion;
    venta.keyPago = request.venta.keyPago;
    venta.estadoVenta = request.venta.estadoVenta;

    _ventaRepository.Update(venta);

    return venta;
  }
}
