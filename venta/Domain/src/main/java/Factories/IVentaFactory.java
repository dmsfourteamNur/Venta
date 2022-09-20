package Factories;

import java.util.UUID;

import Model.Ventas.Venta;

public interface IVentaFactory {
  public Venta Create(String nombre, String apellido, int dni, UUID keyVuelo);
}
