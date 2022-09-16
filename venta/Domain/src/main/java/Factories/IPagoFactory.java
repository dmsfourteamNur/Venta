package Factories;

import Model.Pagos.Pago;

public interface IPagoFactory {
  public Pago Create(String descripcion);
}
