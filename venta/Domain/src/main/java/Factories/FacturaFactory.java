package Factories;

import java.util.UUID;

import Model.Facturas.Factura;

public class FacturaFactory implements IFacturaFactory {

  public FacturaFactory() {}

  @Override
  public Factura Create(UUID keyVenta, String nit, String razonSocial, Double monto, String detalle) {
    return new Factura(keyVenta, nit, razonSocial, monto, detalle);
  }
}
