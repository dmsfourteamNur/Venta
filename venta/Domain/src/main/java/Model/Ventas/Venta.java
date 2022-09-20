package Model.Ventas;

import core.AggregateRoot;
import java.time.LocalDateTime;
import java.util.UUID;

import Event.VentaCreada;

public class Venta extends AggregateRoot<UUID> {

  public String nombre;
  public String apellido;
  public int dni;
  public UUID keyVuelo;
  public Integer estadoVenta;
  public LocalDateTime fechaOn;
  public Integer estado;

  public Venta() {
  }



  public Venta(String nombre, String apellido, int dni, UUID keyVuelo) {
    key = UUID.randomUUID();
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.keyVuelo = keyVuelo;
    this.estadoVenta = 0;
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
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
    addDomainEvent(new VentaCreada( nombre, apellido,dni,keyVuelo));
  }

}
