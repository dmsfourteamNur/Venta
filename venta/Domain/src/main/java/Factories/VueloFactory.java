package Factories;

import java.util.UUID;

import Model.Vuelo.Vuelo;

public class VueloFactory implements IVueloFactory {

  public VueloFactory() {}

  @Override
  public Vuelo Create(UUID key, Integer cantidad, Double precio) {
    return new Vuelo(key, cantidad, precio);
  }
}
