package Model.Recibos;

import core.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Recibo extends Entity<UUID> {

  public UUID keyVenta;
  public String nit;
  public String razonSocial;
  public Double monto;
  public String detalle;
  public Integer estado;
  public LocalDateTime fechaOn;


  public Recibo(UUID keyVenta, String nit, String razonSocial, Double monto, String detalle) {
    key = UUID.randomUUID();
    this.keyVenta = keyVenta;
    this.nit = nit;
    this.razonSocial = razonSocial;
    this.monto = monto;
    this.detalle = detalle;
    this.fechaOn = LocalDateTime.now();
    this.estado = 1;
  }

  public UUID getKeyVenta() {
    return this.keyVenta;
  }

  public void setKeyVenta(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }

  public String getNit() {
    return this.nit;
  }

  public void setNit(String nit) {
    this.nit = nit;
  }

  public String getRazonSocial() {
    return this.razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public Double getMonto() {
    return this.monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public String getDetalle() {
    return this.detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public Integer getEstado() {
    return this.estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

  public LocalDateTime getFechaOn() {
    return this.fechaOn;
  }

  public void setFechaOn(LocalDateTime fechaOn) {
    this.fechaOn = fechaOn;
  }
}
