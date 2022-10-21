package UseCases.Queries.Pagos.GetAll;

import Repositories.IPagoRepository;
import Fourteam.mediator.RequestHandler;
import Model.Ventas.Pago;

import java.util.List;

public class GetAllPagoHandler
  implements RequestHandler<GetAllPagoQuery, List<Pago>> {

  private IPagoRepository _pagoRepository;

  public GetAllPagoHandler(IPagoRepository pagoRepository) {
    this._pagoRepository = pagoRepository;
  }

  @Override
  public List<Pago> handle(GetAllPagoQuery request) throws Exception {
    return _pagoRepository.GetAll();
  }
}
