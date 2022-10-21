package UseCases.Command.Pagos.Crear;

import Dto.PagoDto;
import Fourteam.mediator.Request;

public class CrearPagoCommand implements Request<PagoDto> {

  public PagoDto data;

  public CrearPagoCommand(PagoDto data) {
    this.data = data;
  }

}
