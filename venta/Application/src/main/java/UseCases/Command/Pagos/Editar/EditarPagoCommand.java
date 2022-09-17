package UseCases.Command.Pagos.Editar;

import Dto.PagoDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EditarPagoCommand implements Request<PagoDto> {

  public PagoDto pago;

  public EditarPagoCommand(UUID key) {
    this.pago = new PagoDto();
    this.pago.key = key;
  }
}
