package UseCases.Queries.Facturas.GetAll;

import Repositories.IFacturaRepository;
import fourteam.mediator.RequestHandler;
import java.util.List;

import Model.Facturas.Factura;

public class GetAllFacturaHandler
  implements RequestHandler<GetAllFacturaQuery, List<Factura>> {

  private IFacturaRepository _facturaRepository;

  public GetAllFacturaHandler(IFacturaRepository facturaRepository) {
    this._facturaRepository = facturaRepository;
  }

  @Override
  public List<Factura> handle(GetAllFacturaQuery request) {
    return _facturaRepository.GetAll();
  }
}
