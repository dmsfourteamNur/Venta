package UseCases.Command.Pagos.Crear;

import Factories.IPagoFactory;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;

public class CrearPagoHandler
  implements RequestHandler<CrearPagoCommand, Pago> {

  private IPagoFactory _pagoFactory;
  private IPagoRepository _pagoRepository;
  private IUnitOfWork _unitOfWork;

  public CrearPagoHandler(
    IPagoFactory pagoFactory,
    IPagoRepository pagoRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._pagoFactory = pagoFactory;
    this._pagoRepository = pagoRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Pago handle(CrearPagoCommand request) throws Exception {
    Pago pago = _pagoFactory.Create(request.descripcion);
    // pago.eventCreado();
    _pagoRepository.Create(pago);
    _unitOfWork.commit();
    return pago;
  }
}
