package UseCases.Command.Pagos.Eliminar;

import Factories.IPagoFactory;
import Repositories.IPagoRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Ventas.Pago;

public class EliminarPagoHandler
  implements RequestHandler<EliminarPagoCommand, Pago> {

  private IPagoFactory _pagoFactory;
  private IPagoRepository _pagoRepository;
  private IUnitOfWork _unitOfWork;

  public EliminarPagoHandler(
    IPagoFactory pagoFactory,
    IPagoRepository pagoRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._pagoFactory = pagoFactory;
    this._pagoRepository = pagoRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Pago handle(EliminarPagoCommand request) throws Exception {
    Pago pago = _pagoRepository.FindByKey(request.pago.key);
    if (pago == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Pago no encontrado");
    }

    return _pagoRepository.Delete(pago);
  }
}
