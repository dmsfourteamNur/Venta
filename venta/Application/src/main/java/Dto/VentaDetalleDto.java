package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VentaDetalleDto {

  public UUID keyVenta;
  public UUID keyPasajero;
  public UUID keyVuelo;
  public Double precioVenta;

  public VentaDetalleDto() {
  }

  public VentaDetalleDto(UUID keyVenta, UUID keyPasajero, UUID keyVuelo, Double precioVenta) {
    this.keyVenta = keyVenta;
    this.keyPasajero = keyPasajero;
    this.keyVuelo = keyVuelo;
    this.precioVenta = precioVenta;
  }

  public UUID getKeyVenta() {
    return this.keyVenta;
  }

  public void setKeyVenta(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }

  public UUID getKeyPasajero() {
    return this.keyPasajero;
  }

  public void setKeyPasajero(UUID keyPasajero) {
    this.keyPasajero = keyPasajero;
  }

  public UUID getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public Double getPrecioVenta() {
    return this.precioVenta;
  }

  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

}
