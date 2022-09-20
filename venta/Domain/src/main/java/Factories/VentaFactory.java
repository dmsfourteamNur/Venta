package Factories;

import java.util.UUID;

import Model.Pagos.Pago;
import Model.Ventas.Venta;

public class VentaFactory implements IVentaFactory {

  public VentaFactory() {}

  @Override
  public Venta Create(String nombre, String apellido, String dni, UUID keyVuelo, Integer estadoVenta) {
    // TODO Auto-generated method stub
    return new Venta(nombre, apellido,dni,keyVuelo,estadoVenta);
  }

  // @Override
  // public Venta Create(String nombre,Integer estadoVenta) {
  //   return new Venta(descripcion, estadoVenta);
  // }
}
