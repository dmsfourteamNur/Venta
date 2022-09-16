package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PagoDto {

  public UUID key;
  public String descripcion;




  public PagoDto() {
  }
  public PagoDto(String descripcion) {
    this.descripcion = descripcion;
  }

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


}
