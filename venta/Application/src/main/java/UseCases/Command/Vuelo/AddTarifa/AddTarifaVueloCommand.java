package UseCases.Command.Vuelo.AddTarifa;

import java.util.UUID;

import Dto.AsientoDto;
import Dto.TarifaDto;
import Fourteam.mediator.Request;

public class AddTarifaVueloCommand implements Request<TarifaDto> {

  public UUID key;
  public TarifaDto data;

  public AddTarifaVueloCommand(UUID key) {
    this.key = key;
  }

  public void set(TarifaDto data) {
    this.data = data;
  }
}
