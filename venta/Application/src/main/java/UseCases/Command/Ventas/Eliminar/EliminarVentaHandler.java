package UseCases.Command.Ventas.Eliminar;

import Factories.IVentaFactory;
import Model.Ventas.Venta;
import Model.Ventas.Venta;
import Repositories.IVentaRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class EliminarVentaHandler
  implements RequestHandler<EliminarVentaCommand, Venta> {

  private IVentaFactory _ventaFactory;
  private IVentaRepository _ventaRepository;
  private IUnitOfWork _unitOfWork;

  public EliminarVentaHandler(
    IVentaFactory ventaFactory,
    IVentaRepository ventaRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._ventaFactory = ventaFactory;
    this._ventaRepository = ventaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Venta handle(EliminarVentaCommand request) throws Exception {
    Venta venta = _ventaRepository.FindByKey(request.venta.key);
    if (venta == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Venta no encontrada");
    }

    return _ventaRepository.Delete(venta);
  }
}
