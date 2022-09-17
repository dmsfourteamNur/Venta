package UseCases.Queries.Facturas.GetByKey;

import Dto.FacturaDto;
import Model.Facturas.Factura;
import Repositories.IFacturaRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class GetFacturaByKeyHandler
  implements RequestHandler<GetFacturaByKeyQuery, FacturaDto> {

  private IFacturaRepository _marcaRepository;

  public GetFacturaByKeyHandler(IFacturaRepository marcaRepository) {
    this._marcaRepository = marcaRepository;
  }

  @Override
  public FacturaDto handle(GetFacturaByKeyQuery request) throws Exception {
    Factura marca = _marcaRepository.FindByKey(request.key);
    if (marca == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Factura no encontrada");
    }
    FacturaDto marcaDto = new FacturaDto();
    marcaDto.key = marca.key;
    marcaDto.nit = marca.nit;
    return marcaDto;
  }
}
