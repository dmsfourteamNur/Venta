package Factories;

import java.util.UUID;

import Model.Ventas.Pago;

public interface IPagoFactory {
  public Pago Create(String descripcion, UUID keyVenta, double monto, String tipo);
}
