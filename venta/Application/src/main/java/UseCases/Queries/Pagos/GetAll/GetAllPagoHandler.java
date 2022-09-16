package UseCases.Queries.Pagos.GetAll;

import Repositories.IPagoRepository;
import fourteam.mediator.RequestHandler;
import java.util.List;

import Model.Pagos.Pago;

public class GetAllPagoHandler
  implements RequestHandler<GetAllPagoQuery, List<Pago>> {

  private IPagoRepository _pagoRepository;

  public GetAllPagoHandler(IPagoRepository pagoRepository) {
    this._pagoRepository = pagoRepository;
  }

  @Override
  public List<Pago> handle(GetAllPagoQuery request) {
    return _pagoRepository.GetAll();
  }
}
