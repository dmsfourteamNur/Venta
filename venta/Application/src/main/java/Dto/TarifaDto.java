package Dto;

import java.util.UUID;

public class TarifaDto {

  public UUID key;
  public String descripcion;
  public double precio;
  public int cantidad;

  public TarifaDto(UUID key, String descripcion, double precio, int cantidad) {
    this.key = key;
    this.descripcion = descripcion;
    this.precio = precio;
    this.cantidad = cantidad;
  }

}
