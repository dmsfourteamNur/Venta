package UseCases.Queries.Facturas.GetByKey;

import Dto.PagoDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetFacturaByKeyQuery implements Request<PagoDto> {

  public GetFacturaByKeyQuery(UUID key) {
    this.key = key;
  }

  public UUID key;
}
