package Model.Vuelo;

import core.Entity;
import java.util.UUID;

public class Tarifa extends Entity<UUID> {

  private double precio;
  private String decripcion;
  private int cantidad;

  public Tarifa() {
  }

  public Tarifa(UUID key, String descripcion, double precio, int cantidad) {
    this.key = key;
    this.decripcion = descripcion;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public double getPrecio() {
    return precio;
  }

  public void setDecripcion(String decripcion) {
    this.decripcion = decripcion;
  }

  public String getDecripcion() {
    return decripcion;
  }

  public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
  }
  public int getCantidad() {
      return cantidad;
  }
}
