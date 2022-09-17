package UseCases.Command.Facturas.Crear;

import java.time.LocalDateTime;
import java.util.UUID;

import Dto.FacturaDto;
import Fourteam.mediator.Request;

public class CrearFacturaCommand implements Request<FacturaDto> {

  public String nit;
  public String razonSocial;
  public UUID keyVenta;
  public Double monto;
  public String detalle;
  public Integer estado;
  public LocalDateTime fechaOn;

  public CrearFacturaCommand(FacturaDto ero) {
    this.nit = ero.nit;
    this.razonSocial = ero.razonSocial;
    this.keyVenta = ero.keyVenta;
    this.detalle = ero.detalle;
  }

}
