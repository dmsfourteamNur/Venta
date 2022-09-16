package UseCases.Command.Ventas.Crear;

import java.util.UUID;

import Dto.VentaDto;
import fourteam.mediator.Request;

public class CrearVentaCommand implements Request<VentaDto> {

  public String descripcion;
  public UUID keyPago;
  public Integer estadoVenta;


  public CrearVentaCommand(VentaDto venta) {
    this.descripcion = venta.descripcion;
    this.keyPago = venta.keyPago;
    this.estadoVenta = venta.estadoVenta;
  }

}
