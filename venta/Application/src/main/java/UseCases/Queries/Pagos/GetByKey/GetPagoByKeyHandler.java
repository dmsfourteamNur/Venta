package UseCases.Queries.Pagos.GetByKey;

import Dto.PagoDto;
import Dto.AsientoDto;
import Repositories.IPagoRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Ventas.Pago;

public class GetPagoByKeyHandler
  implements RequestHandler<GetPagoByKeyQuery, PagoDto> {

  private IPagoRepository _pagoRepository;

  public GetPagoByKeyHandler(IPagoRepository pagoRepository) {
    this._pagoRepository = pagoRepository;
  }

  @Override
  public PagoDto handle(GetPagoByKeyQuery request)
    throws Exception {
    Pago pago = _pagoRepository.FindByKey(request.key);
    if (pago == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Pago no encontrado");
    }
    PagoDto pagoDto = new PagoDto();
    pagoDto.key = pago.key;
    pagoDto.descripcion = pago.descripcion;

    return pagoDto;
  }
}
