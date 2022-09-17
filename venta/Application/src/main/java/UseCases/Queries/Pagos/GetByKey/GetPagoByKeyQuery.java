package UseCases.Queries.Pagos.GetByKey;

import Dto.PagoDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetPagoByKeyQuery implements Request<PagoDto> {

  public UUID key;

  public GetPagoByKeyQuery(UUID key) {
    this.key = key;
  }

}
