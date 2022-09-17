package Controllers;

import UseCases.Command.Facturas.Crear.CrearFacturaCommand;
import UseCases.Command.Facturas.Editar.EditarFacturaCommand;
import UseCases.Command.Facturas.Eliminar.EliminarFacturaCommand;
import UseCases.Queries.Facturas.GetAll.GetAllFacturaQuery;
import UseCases.Queries.Facturas.GetByKey.GetFacturaByKeyQuery;
import Fourteam.http.annotation.*;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import java.util.ArrayList;
import java.util.List;

import Model.Facturas.*;

@RestController
@RequestMapping("/factura")
public class FacturaController {

  private Mediator _mediator;

  public FacturaController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/")
  public Response<List<Factura>> getAll() throws Exception {
    return _mediator.send(new GetAllFacturaQuery());
  }

  @GetMapping("/{key}")
  public Response<Factura> getByKey(@PathVariable GetFacturaByKeyQuery request)
    throws Exception {
    return _mediator.send(request);
  }

  @PostMapping("/registro")
  public Response<Factura> register(@RequestBody CrearFacturaCommand factura)
    throws Exception {
    return _mediator.send(factura);
  }

  @PutMapping("/{key}")
  public Response<Factura> edit(
    @RequestBody Factura factura,
    @PathVariable EditarFacturaCommand request
  ) throws Exception {
    request.factura.nit = factura.nit;
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Factura> delete(@PathVariable EliminarFacturaCommand request)
    throws Exception {
    return _mediator.send(request);
  }
}
