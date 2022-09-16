package UseCases.Queries.Ventas.GetByKey;

import Dto.PagoDto;
import Dto.AsientoDto;
import Dto.VentaDto;
import Model.Pagos.Pago;
import Model.Ventas.Venta;
import Repositories.IPagoRepository;
import Repositories.IVentaRepository;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class GetVentaByKeyHandler
  implements RequestHandler<GetVentaByKeyQuery, VentaDto> {

  private IVentaRepository _ventaRepository;

  public GetVentaByKeyHandler(IVentaRepository ventaRepository) {
    this._ventaRepository = ventaRepository;
  }

  @Override
  public VentaDto handle(GetVentaByKeyQuery request)
    throws HttpException {
    Venta venta = _ventaRepository.FindByKey(request.key);
    if (venta == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Venta no encontrada");
    }
    VentaDto ventaDto = new VentaDto();
    ventaDto.key = venta.key;
    ventaDto.descripcion = venta.descripcion;
    ventaDto.keyPago = venta.keyPago;
    ventaDto.estadoVenta = venta.estadoVenta;

    return ventaDto;
  }
}
