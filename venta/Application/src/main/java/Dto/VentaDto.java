package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VentaDto {

  public UUID key;
  public String descripcion;
  public UUID keyPago;
  public Integer estadoVenta;

  public VentaDto() {
  }

  public VentaDto(String descripcion, UUID keyPago, Integer estadoVenta) {
    this.descripcion = descripcion;
    this.keyPago = keyPago;
    this.estadoVenta = estadoVenta;
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

  public UUID getKeyPago() {
    return this.keyPago;
  }

  public void setKeyPago(UUID keyPago) {
    this.keyPago = keyPago;
  }

  public Integer getEstadoVenta() {
    return this.estadoVenta;
  }

  public void setEstadoVenta(Integer estadoVenta) {
    this.estadoVenta = estadoVenta;
  }

}
