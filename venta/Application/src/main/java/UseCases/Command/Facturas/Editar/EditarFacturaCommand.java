package UseCases.Command.Facturas.Editar;

import Dto.FacturaDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EditarFacturaCommand implements Request<FacturaDto> {

  public FacturaDto factura;

  public EditarFacturaCommand(UUID key) {
    this.factura = new FacturaDto();
    this.factura.key = key;
  }
}
