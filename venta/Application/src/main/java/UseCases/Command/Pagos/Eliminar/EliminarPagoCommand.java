package UseCases.Command.Pagos.Eliminar;

import Dto.PagoDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EliminarPagoCommand implements Request<PagoDto> {

  PagoDto pago;

  public EliminarPagoCommand(UUID key) {
    this.pago = new PagoDto();
    this.pago.key = key;
  }
}
