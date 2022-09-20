package UseCases.Command.Pagos.Crear;

import Dto.PagoDto;
import Fourteam.mediator.Request;

public class CrearPagoCommand implements Request<PagoDto> {

  public String descripcion;

  public CrearPagoCommand(PagoDto ero) {
    this.descripcion = ero.descripcion;
  }

}