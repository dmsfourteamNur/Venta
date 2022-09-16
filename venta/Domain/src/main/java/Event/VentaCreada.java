package Event;

import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.UUID;

public class VentaCreada extends DomainEvent {

  public UUID keyVenta;
  public String descripcion;

  public VentaCreada() {
    super();
  }

  public VentaCreada(UUID keyVenta, String descripcion) {
    super(LocalDateTime.now());
    this.keyVenta = keyVenta;
    this.descripcion = descripcion;
  }

  public UUID getKeyAeronave() {
    return this.keyVenta;
  }

  public void setKeyAeronave(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }

  public String getMatricula() {
    return this.descripcion;
  }

  public void setMatricula(String descripcion) {
    this.descripcion = descripcion;
  }
}
