package Model.Ventas;

import core.AggregateRoot;
import java.time.LocalDateTime;
import java.util.UUID;

import Event.VentaCreada;

public class Venta extends AggregateRoot<UUID> {

  public String descripcion;
  public UUID keyPago;
  public Integer estadoVenta;
  public LocalDateTime fechaOn;
  public Integer estado;

  public Venta() {
  }

  public Venta(String descripcion, UUID keyPago, Integer estadoVenta) {
    key = UUID.randomUUID();
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
    this.descripcion = descripcion;
    this.keyPago = keyPago;
    this.estadoVenta = estadoVenta;

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

  public void eventCreado() {
    addDomainEvent(new VentaCreada(key, descripcion));
  }

}
