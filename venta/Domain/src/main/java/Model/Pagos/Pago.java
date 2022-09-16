package Model.Pagos;

import Event.VentaCreada;
import core.AggregateRoot;
import core.BussinessRuleValidateExeption;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pago extends AggregateRoot<UUID> {

  public String descripcion;
  public Integer estado;
  public LocalDateTime fechaOn;

  public Pago() {}

  public Pago(String descripcion) {
    key = UUID.randomUUID();
    this.descripcion = descripcion;
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
  }

  public void eventCreado() {
    //addDomainEvent(new AeronaveCreado(key, descripcion));
  }


}
