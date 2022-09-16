package Factories;

import Model.Pagos.Pago;

public class PagoFactory implements IPagoFactory {

  public PagoFactory() {}

  @Override
  public Pago Create(String description) {
    return new Pago(description);
  }
}
