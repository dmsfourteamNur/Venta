package Model.Ventas;

import Event.VentaCreada;
import core.AggregateRoot;
import core.BussinessRuleValidateExeption;
import core.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pago extends Entity<UUID> {

  public String descripcion;
  public Integer estado;
  public LocalDateTime fechaOn;
  public double monto;
  public String tipo;

  public Pago() {
  }

  public Pago(String descripcion, double monto, String tipo) {
    key = UUID.randomUUID();
    this.descripcion = descripcion;
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
    this.monto = monto;
    this.tipo = tipo;
  }

  public void eventCreado() {
    // addDomainEvent(new AeronaveCreado(key, descripcion));
  }

}
