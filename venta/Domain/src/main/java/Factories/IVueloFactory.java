package Factories;

import java.util.UUID;

import Model.Vuelo.Vuelo;

public interface IVueloFactory {
  public Vuelo Create(UUID key, Integer cantidad, Double precio);
}
