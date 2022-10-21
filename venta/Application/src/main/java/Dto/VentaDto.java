package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Model.Ventas.Venta;

public class VentaDto {

  public UUID key;
  public String nombre;
  public String apellido;
  public String dni;
  public UUID keyVuelo;
  public UUID keyTarifa;
  public double monto;

  public VentaDto() {
  }

  public VentaDto(UUID key, String nombre, String apellido, String dni, UUID keyVuelo, UUID keyTarifa) {
    this.key = key;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.keyVuelo = keyVuelo;
    this.keyTarifa = keyTarifa;
  }

  public VentaDto(UUID key, String nombre, String apellido, String dni, UUID keyVuelo, UUID keyTarifa, double monto) {
    this.key = key;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.keyVuelo = keyVuelo;
    this.keyTarifa = keyTarifa;
    this.monto = monto;
  }

  public VentaDto(Venta venta) {
    this.key = venta.key;
    this.nombre = venta.nombre;
    this.apellido = venta.apellido;
    this.dni = venta.dni;
    this.keyVuelo = venta.keyVuelo;
    this.keyTarifa = venta.keyTarifa;
    this.monto = venta.monto;
  }

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

}
