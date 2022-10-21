package Factories;

import java.util.UUID;

import Model.Ventas.Pago;

public class PagoFactory implements IPagoFactory {

  public PagoFactory() {
  }

  @Override
  public Pago Create(String description, UUID keyVenta, double monto, String tipo) {
    return new Pago(description, monto, tipo);
  }
}
