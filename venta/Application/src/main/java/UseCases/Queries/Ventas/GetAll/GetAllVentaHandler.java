package UseCases.Queries.Ventas.GetAll;

import Model.Ventas.Venta;
import Repositories.IVentaRepository;
import Fourteam.mediator.RequestHandler;

import java.util.ArrayList;
import java.util.List;

import Dto.VentaDto;

public class GetAllVentaHandler
    implements RequestHandler<GetAllVentaQuery, List<VentaDto>> {

  private IVentaRepository _ventaRepository;

  public GetAllVentaHandler(IVentaRepository ventaRepository) {
    this._ventaRepository = ventaRepository;
  }

  @Override
  public List<VentaDto> handle(GetAllVentaQuery request) throws Exception {
    List<VentaDto> resp = new ArrayList<>();
    _ventaRepository.GetAll().iterator().forEachRemaining(venta -> {
      resp.add(new VentaDto(venta));
    });
    return resp;
  }
}
