package UseCases.Command.Pagos.Editar;

import Factories.IPagoFactory;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class EditarPagoHandler
  implements RequestHandler<EditarPagoCommand, Pago> {

  private IPagoFactory _pagoFactory;
  private IPagoRepository _pagoRepository;
  private IUnitOfWork _unitOfWork;

  public EditarPagoHandler(
    IPagoFactory pagoFactory,
    IPagoRepository pagoRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._pagoFactory = pagoFactory;
    this._pagoRepository = pagoRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Pago handle(EditarPagoCommand request) throws Exception {
    Pago pago = _pagoRepository.FindByKey(request.pago.key);
    if (pago == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Pago no encontrado");
    }
    pago.descripcion = request.pago.descripcion;
    _pagoRepository.Update(pago);
    return pago;
  }
}
