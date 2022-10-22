package Controllers;

import Dto.VentaDto;
import Model.Ventas.Venta;
import UseCases.Command.Ventas.Crear.CrearVentaCommand;
import UseCases.Command.Ventas.Editar.EditarVentaCommand;
import UseCases.Command.Ventas.Eliminar.EliminarVentaCommand;
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
import Fourteam.mediator.Response;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/venta")
public class VentaController {

  private Mediator _mediator;

  public VentaController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/")
  public List<Venta> getAll() throws Exception {
    return (List<Venta>) _mediator.send(new GetAllVentaQuery()).data;
  }

  @GetMapping("/{key}")
  public VentaDto getByKey(
      @PathVariable GetVentaByKeyQuery request) throws Exception {
    return (VentaDto) _mediator.send(request).data;
  }

  @PostMapping("/registro")
  public String register(
      @RequestBody CrearVentaCommand venta) throws Exception {
    return _mediator.send(venta).data.toString();
  }

  @PutMapping("/{key}")
  public Response<Venta> edit(
      @RequestBody Venta venta,
      @PathVariable EditarVentaCommand request) throws Exception {
    // request.venta.descripcion = venta.descripcion;
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Venta> delete(
      @PathVariable EliminarVentaCommand request) throws Exception {
    return _mediator.send(request);
  }
}
