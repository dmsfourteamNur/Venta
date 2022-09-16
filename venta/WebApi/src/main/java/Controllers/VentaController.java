package Controllers;

import Dto.VentaDto;
import Model.Ventas.Venta;
import UseCases.Command.Ventas.Crear.CrearVentaCommand;
import UseCases.Command.Ventas.Editar.EditarVentaCommand;
import UseCases.Command.Ventas.Eliminar.EliminarVentaCommand;
import UseCases.Queries.Ventas.GetAll.GetAllVentaQuery;
import UseCases.Queries.Ventas.GetByKey.GetVentaByKeyQuery;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.DeleteMapping;
import fourteam.http.annotation.GetMapping;
import fourteam.http.annotation.PathVariable;
import fourteam.http.annotation.PostMapping;
import fourteam.http.annotation.PutMapping;
import fourteam.http.annotation.RequestBody;
import fourteam.http.annotation.RequestMapping;
import fourteam.http.annotation.RestController;
import fourteam.mediator.Mediator;
import fourteam.mediator.Response;
import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

  private Mediator _mediator;

  public VentaController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/")
  public Response<List<Venta>> getAll() throws HttpException {
    return _mediator.send(new GetAllVentaQuery());
  }

  @GetMapping("/{key}")
  public Response<VentaDto> getByKey(
    @PathVariable GetVentaByKeyQuery request
  ) throws HttpException {
    return _mediator.send(request);
  }

  @PostMapping("/registro")
  public Response<Venta> register(
    @RequestBody CrearVentaCommand venta
  ) throws HttpException {
    return _mediator.send(venta);
  }

  @PutMapping("/{key}")
  public Response<Venta> edit(
    @RequestBody Venta venta,
    @PathVariable EditarVentaCommand request
  ) throws HttpException {
    request.venta.descripcion = venta.descripcion;
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Venta> delete(
    @PathVariable EliminarVentaCommand request
  ) throws HttpException {
    return _mediator.send(request);
  }
}
