package Factories;

import java.util.UUID;

import Model.Facturas.Factura;
import Model.Recibos.Recibo;

public class ReciboFactory implements IReciboFactory {

  public ReciboFactory() {}

  @Override
  public Recibo Create(UUID keyVenta, String nit, String razonSocial, Double monto, String detalle) {
    return new Recibo(keyVenta, nit, razonSocial, monto, detalle);
  }
}
