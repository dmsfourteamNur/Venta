package UseCases.Command.Pagos.Eliminar;

import Factories.IPagoFactory;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

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
  public Pago handle(EliminarPagoCommand request) throws HttpException {
    Pago pago = _pagoRepository.FindByKey(request.pago.key);
    if (pago == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Pago no encontrado");
    }

    return _pagoRepository.Delete(pago);
  }
}
