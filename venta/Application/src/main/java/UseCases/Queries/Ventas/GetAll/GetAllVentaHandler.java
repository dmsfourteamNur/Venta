package UseCases.Queries.Ventas.GetAll;

import Model.Ventas.Venta;
import Repositories.IVentaRepository;
import fourteam.mediator.RequestHandler;
import java.util.List;

public class GetAllVentaHandler
  implements RequestHandler<GetAllVentaQuery, List<Venta>> {

  private IVentaRepository _ventaRepository;

  public GetAllVentaHandler(IVentaRepository ventaRepository) {
    this._ventaRepository = ventaRepository;
  }

  @Override
  public List<Venta> handle(GetAllVentaQuery request) {
    return _ventaRepository.GetAll();
  }
}
