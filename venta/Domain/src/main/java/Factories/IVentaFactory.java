package Factories;

import java.util.UUID;

import Model.Ventas.Venta;

public interface IVentaFactory {
  public Venta Create(String descripcion, UUID keyPago, Integer estadoVenta);
}
