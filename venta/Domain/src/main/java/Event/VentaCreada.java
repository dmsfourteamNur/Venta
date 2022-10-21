package Event;

import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.UUID;

public class VentaCreada extends DomainEvent {

  public UUID keyVenta;
  public UUID keyVuelo;
  public String nombre;
  public String apellido;
  public String dni;

  public VentaCreada() {
    super();
  }

  public VentaCreada(String nombre, String apellido, String dni, UUID keyVuelo, UUID keyVenta) {
    super(LocalDateTime.now());
    this.keyVuelo = keyVuelo;
    this.keyVenta = keyVenta;
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public UUID getKeyVenta() {
    return this.keyVenta;
  }

  public void setKeyVenta(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }

  public UUID getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }
}
