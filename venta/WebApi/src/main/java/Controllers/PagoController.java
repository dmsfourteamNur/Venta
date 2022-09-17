package Controllers;

import Dto.PagoDto;
import Model.Pagos.Pago;
import UseCases.Command.Pagos.Crear.CrearPagoCommand;
import UseCases.Command.Pagos.Editar.EditarPagoCommand;
import UseCases.Command.Pagos.Eliminar.EliminarPagoCommand;
import UseCases.Queries.Pagos.GetAll.GetAllPagoQuery;
import UseCases.Queries.Pagos.GetByKey.GetPagoByKeyQuery;
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

@RestController
@RequestMapping("/pago")
public class PagoController {

  private Mediator _mediator;

  public PagoController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/")
  public Response<List<Pago>> getAll() throws Exception {
    return _mediator.send(new GetAllPagoQuery());
  }

  @GetMapping("/{key}")
  public Response<PagoDto> getByKey(
    @PathVariable GetPagoByKeyQuery request
  ) throws Exception {
    return _mediator.send(request);
  }

  @PostMapping("/registro")
  public Response<Pago> register(
    @RequestBody CrearPagoCommand pago
  ) throws Exception {
    return _mediator.send(pago);
  }

  @PutMapping("/{key}")
  public Response<Pago> edit(
    @RequestBody Pago pago,
    @PathVariable EditarPagoCommand request
  ) throws Exception {
    request.pago.descripcion = pago.descripcion;
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Pago> delete(
    @PathVariable EliminarPagoCommand request
  ) throws Exception {
    return _mediator.send(request);
  }
}
