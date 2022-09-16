package Model.Ventas;

import core.AggregateRoot;
import core.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import Event.VentaCreada;

public class VentaDetalle extends Entity<UUID> {

  public UUID keyVenta;
  public UUID keyPasajero;
  public UUID keyVuelo;
  public Double precioVenta;
  public LocalDateTime fechaOn;
  public Integer estado;


  public VentaDetalle() {
  }

  public VentaDetalle(UUID keyVenta, UUID keyPasajero, UUID keyVuelo, Double precioVenta) {
    key = UUID.randomUUID();
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
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

  public LocalDateTime getFechaOn() {
    return this.fechaOn;
  }

  public void setFechaOn(LocalDateTime fechaOn) {
    this.fechaOn = fechaOn;
  }

  public Integer getEstado() {
    return this.estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }


  // public void eventCreado() {
  //   addDomainEvent(new VentaCreada(key, keyVenta));
  // }

}
