package UseCases.Command.Ventas.Eliminar;

import Dto.VentaDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EliminarVentaCommand implements Request<VentaDto> {

  VentaDto venta;

  public EliminarVentaCommand(UUID key) {
    this.venta = new VentaDto();
    this.venta.key = key;
  }
}
