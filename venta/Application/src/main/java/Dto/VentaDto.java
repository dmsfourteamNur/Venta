package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Model.Ventas.Pago;
import Model.Ventas.Venta;

public class VentaDto {

  public UUID key;
  public String nombre;
  public String apellido;
  public String dni;
  public UUID keyVuelo;
  public UUID keyTarifa;
  public double monto;

  public List<Pago> pagos;


  public VentaDto() {
  }

  public VentaDto(UUID key, String nombre, String apellido, String dni, UUID keyVuelo, UUID keyTarifa) {
    this.key = key;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.keyVuelo = keyVuelo;
    this.keyTarifa = keyTarifa;
    this.pagos= new ArrayList<>();
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
    return this.dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public UUID getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public UUID getKeyTarifa() {
    return this.keyTarifa;
  }

  public void setKeyTarifa(UUID keyTarifa) {
    this.keyTarifa = keyTarifa;
  }

  public double getMonto() {
    return this.monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }


  public List<Pago> getPagos() {
    return this.pagos;
  }

  public void setPagos(List<Pago> pagos) {
    this.pagos = pagos;
  }

}
