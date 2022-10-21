package Model.Ventas;

import core.AggregateRoot;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Event.VentaCreada;

public class Venta extends AggregateRoot<UUID> {

  public String nombre;
  public String apellido;
  public String dni;
  public UUID keyVuelo;
  public UUID keyTarifa;
  public Integer estadoVenta;
  public LocalDateTime fechaOn;
  public Integer estado;
  public double monto;
  public List<Pago> pagos;

  public Venta() {
  }

  public Venta(String nombre, String apellido, String dni, UUID keyVuelo, UUID keyTarifa, double monto) {
    key = UUID.randomUUID();
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.keyVuelo = keyVuelo;
    this.keyTarifa = keyTarifa;
    this.estadoVenta = 0;
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
    this.monto = monto;
    this.pagos= new ArrayList<>();
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

  public UUID getKeyTarifa() {
    return keyTarifa;
  }

  public void setKeyTarifa(UUID keyTarifa) {
    this.keyTarifa = keyTarifa;
  }

  public void eventCreado() {
    addDomainEvent(new VentaCreada(nombre, apellido, dni, keyVuelo, this.key));
  }

}
