package UseCases.Command.Facturas.Eliminar;

import Dto.FacturaDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EliminarFacturaCommand implements Request<FacturaDto> {

  FacturaDto factura;

  public EliminarFacturaCommand(UUID key) {
    this.factura = new FacturaDto();
    this.factura.key = key;
  }
}
