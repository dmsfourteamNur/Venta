package Controllers;

import Dto.PagoDto;
import Model.Pagos.Pago;
import UseCases.Command.Pagos.Crear.CrearPagoCommand;
import UseCases.Command.Pagos.Editar.EditarPagoCommand;
import UseCases.Command.Pagos.Eliminar.EliminarPagoCommand;
import UseCases.Queries.Pagos.GetAll.GetAllPagoQuery;
import UseCases.Queries.Pagos.GetByKey.GetPagoByKeyQuery;
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
@RequestMapping("/pago")
public class PagoController {

  private Mediator _mediator;

  public PagoController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/")
  public Response<List<Pago>> getAll() throws HttpException {
    return _mediator.send(new GetAllPagoQuery());
  }

  @GetMapping("/{key}")
  public Response<PagoDto> getByKey(
    @PathVariable GetPagoByKeyQuery request
  ) throws HttpException {
    return _mediator.send(request);
  }

  @PostMapping("/registro")
  public Response<Pago> register(
    @RequestBody CrearPagoCommand pago
  ) throws HttpException {
    return _mediator.send(pago);
  }

  @PutMapping("/{key}")
  public Response<Pago> edit(
    @RequestBody Pago pago,
    @PathVariable EditarPagoCommand request
  ) throws HttpException {
    request.pago.descripcion = pago.descripcion;
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Pago> delete(
    @PathVariable EliminarPagoCommand request
  ) throws HttpException {
    return _mediator.send(request);
  }
}
