package Model.Vuelo;

import core.AggregateRoot;
import java.time.LocalDateTime;
import java.util.UUID;

public class Vuelo extends AggregateRoot<UUID> {

  public UUID key;
  public Integer cantidad;
  public Double precio;
  public Integer estado;
  public LocalDateTime fechaOn;

  public Vuelo() {
  }

  public Vuelo(UUID key, Integer cantidad, Double precio) {
    this.key = key;
    this.cantidad = cantidad;
    this.precio = precio;
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
  }

  public void eventCreado() {
    // addDomainEvent(new AeronaveCreado(key, descripcion));
  }

}
