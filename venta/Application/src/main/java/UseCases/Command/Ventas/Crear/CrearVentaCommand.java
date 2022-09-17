package UseCases.Command.Ventas.Crear;

import java.util.UUID;

import Dto.VentaDto;
import Fourteam.mediator.Request;

public class CrearVentaCommand implements Request<VentaDto> {

  public VentaDto data;

  public CrearVentaCommand(VentaDto venta) {
    this.data = venta;
  }

}
