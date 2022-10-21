package Controllers;

import java.util.UUID;

import Dto.TarifaDto;
import Dto.VentaDto;
import Model.Ventas.Venta;
import UseCases.Command.Ventas.Crear.CrearVentaCommand;
import UseCases.Command.Ventas.Editar.EditarVentaCommand;
import UseCases.Command.Ventas.Eliminar.EliminarVentaCommand;
import UseCases.Command.Vuelo.AddTarifa.AddTarifaVueloCommand;
import UseCases.Queries.Ventas.GetAll.GetAllVentaQuery;
import UseCases.Queries.Ventas.GetByKey.GetVentaByKeyQuery;
import Fourteam.http.annotation.DeleteMapping;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.PostMapping;
import Fourteam.http.annotation.PutMapping;
import Fourteam.http.annotation.RequestBody;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;

@RestController
@RequestMapping("/vuelo")
public class VueloController {

  private Mediator _mediator;

  public VueloController(Mediator mediator) {
    this._mediator = mediator;
  }

  @PutMapping("/AddTarifa/{key}")
  public UUID addAsiento(
      @RequestBody TarifaDto tarifa,
      @PathVariable AddTarifaVueloCommand request) throws Exception {
    request.set(tarifa);
    return (UUID) _mediator.send(request).data;
  }
}
