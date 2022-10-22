package UseCases.Queries.Ventas.GetAll;

import Model.Ventas.Venta;
import Repositories.IVentaRepository;
import Fourteam.mediator.RequestHandler;

import java.util.ArrayList;
import java.util.List;

import Dto.VentaDto;

public class GetAllVentaHandler
    implements RequestHandler<GetAllVentaQuery, List<VentaDto>> {

  private IVentaRepository _ventaRepository;

  public GetAllVentaHandler(IVentaRepository ventaRepository) {
    this._ventaRepository = ventaRepository;
  }

  @Override
  public List<VentaDto> handle(GetAllVentaQuery request) throws Exception {
    List<VentaDto> resp = new ArrayList<>();
    _ventaRepository.GetAll().iterator().forEachRemaining(venta -> {
      VentaDto venta_dto = new VentaDto();
      venta_dto.setKey(venta.getKey());
      venta_dto.setNombre(venta.nombre);
      venta_dto.setApellido(venta.apellido);
      venta_dto.setMonto(venta.monto);
      venta_dto.setDni(venta.dni);
      venta_dto.setKeyVuelo(venta.keyVuelo);
      venta_dto.setKeyTarifa(venta.keyTarifa);
      venta_dto.setPagos(venta.getPagos());

      resp.add(venta_dto);

      // resp.add(new VentaDto(venta));
    });
    return resp;
  }
}
