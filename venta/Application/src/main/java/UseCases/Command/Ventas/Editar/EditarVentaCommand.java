package UseCases.Command.Ventas.Editar;

import Dto.VentaDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EditarVentaCommand implements Request<VentaDto> {

  public VentaDto venta;

  public EditarVentaCommand(UUID key) {
    this.venta = new VentaDto();
    this.venta.key = key;
  }
}
