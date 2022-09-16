package Dto;

import java.util.UUID;

public class FacturaDto {

  public UUID key;
  public UUID keyVenta;
  public String nit;
  public String razonSocial;
  public Double monto;
  public String detalle;

  public FacturaDto() {
  }

  public FacturaDto(UUID keyVenta, String nit, String razonSocial, Double monto, String detalle) {
    this.keyVenta = keyVenta;
    this.nit = nit;
    this.razonSocial = razonSocial;
    this.monto = monto;
    this.detalle = detalle;
  }
}
