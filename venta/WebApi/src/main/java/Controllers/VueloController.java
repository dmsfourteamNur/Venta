package Controllers;

import java.util.List;
import java.util.UUID;

import Dto.TarifaDto;
import Dto.VentaDto;
import Dto.VueloDto;
import Model.Ventas.Venta;
import Model.Vuelo.Vuelo;
import UseCases.Command.Ventas.Crear.CrearVentaCommand;
import UseCases.Command.Ventas.Editar.EditarVentaCommand;
import UseCases.Command.Ventas.Eliminar.EliminarVentaCommand;
import UseCases.Command.Vuelo.AddTarifa.AddTarifaVueloCommand;
import UseCases.Queries.Ventas.GetAll.GetAllVentaQuery;
import UseCases.Queries.Ventas.GetByKey.GetVentaByKeyQuery;
import UseCases.Queries.Vuelo.GetAll.GetAllVueloQuery;
import Fourteam.mediator.Response;
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


	@GetMapping("/")
	public List<VueloDto> getAll() throws Exception {
		Response<List<VueloDto>> lista = _mediator.send(
			new GetAllVueloQuery()
		);
		return lista.data;
	}

  @PutMapping("/AddTarifa/{key}")
  public UUID addAsiento(
      @RequestBody TarifaDto tarifa,
      @PathVariable AddTarifaVueloCommand request) throws Exception {
    request.set(tarifa);
    return (UUID) _mediator.send(request).data;
  }
}
