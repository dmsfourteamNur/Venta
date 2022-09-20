package Event;

import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.UUID;

public class VentaCreada extends DomainEvent {

  public UUID keyVenta;

  public VentaCreada() {
    super();
  }

  public VentaCreada(UUID keyVenta) {
    super(LocalDateTime.now());
    this.keyVenta = keyVenta;
  }

  public UUID getKeyAeronave() {
    return this.keyVenta;
  }

  public void setKeyAeronave(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }


}
