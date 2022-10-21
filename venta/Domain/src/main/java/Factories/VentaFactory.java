package Factories;

import java.util.UUID;

import Model.Ventas.Pago;
import Model.Ventas.Venta;

public class VentaFactory implements IVentaFactory {

  public VentaFactory() {
  }

  @Override
  public Venta Create(String nombre, String apellido, String dni, UUID keyVuelo, UUID keyTarifa, double monto) {
    // TODO Auto-generated method stub
    return new Venta(nombre, apellido, dni, keyVuelo, keyTarifa, monto);
  }

  // @Override
  // public Venta Create(String nombre,Integer estadoVenta) {
  // return new Venta(descripcion, estadoVenta);
  // }
}
