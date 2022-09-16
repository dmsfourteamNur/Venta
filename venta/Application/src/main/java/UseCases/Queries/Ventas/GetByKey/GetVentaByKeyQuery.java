package UseCases.Queries.Ventas.GetByKey;

import Dto.VentaDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class GetVentaByKeyQuery implements Request<VentaDto> {
  public UUID key;

  public GetVentaByKeyQuery(UUID key) {
    this.key = key;
  }

}
