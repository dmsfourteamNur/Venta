package Factories;

import java.util.UUID;

import Model.Pagos.Pago;
import Model.Ventas.Venta;

public class VentaFactory implements IVentaFactory {

  public VentaFactory() {}

  @Override
  public Venta Create(String descripcion, UUID keyPago, Integer estadoVenta) {
    return new Venta(descripcion, keyPago, estadoVenta);
  }
}
