package UseCases.Queries.Pagos.GetByKey;

import Dto.PagoDto;
import Dto.AsientoDto;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class GetPagoByKeyHandler
  implements RequestHandler<GetPagoByKeyQuery, PagoDto> {

  private IPagoRepository _pagoRepository;

  public GetPagoByKeyHandler(IPagoRepository pagoRepository) {
    this._pagoRepository = pagoRepository;
  }

  @Override
  public PagoDto handle(GetPagoByKeyQuery request)
    throws HttpException {
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
