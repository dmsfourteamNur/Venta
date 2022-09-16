package Factories;

import java.util.UUID;

import Model.Facturas.Factura;

public interface IFacturaFactory {
  public Factura Create(UUID keyVenta, String nit, String razonSocial, Double monto, String detalle);
}
