package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PagoDto {

  public UUID key;
  public UUID keyVenta;
  public String descripcion;
  public String tipo;
  public double monto;

  public PagoDto() {
  }

  public PagoDto(String descripcion, UUID keyVenta, String tipo, double monto) {
    this.descripcion = descripcion;
    this.keyVenta = keyVenta;
    this.tipo = tipo;
    this.monto = monto;
  }

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public UUID getKeyVenta() {
    return keyVenta;
  }

  public void setKeyVenta(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }

}
