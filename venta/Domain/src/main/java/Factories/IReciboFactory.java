package Factories;

import java.util.UUID;

import Model.Recibos.Recibo;

public interface IReciboFactory {
  public Recibo Create(UUID keyVenta, String nit, String razonSocial, Double monto, String detalle);
}
