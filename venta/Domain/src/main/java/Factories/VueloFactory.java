package Factories;

import java.util.Date;
import java.util.UUID;

import Model.Vuelo.Vuelo;

public class VueloFactory implements IVueloFactory {

  public VueloFactory() {
  }

  @Override
  public Vuelo Create(UUID key, String ciudadOrigen, String ciudadDestino, Date fechaSalida, Date fechaArribe) {
    return new Vuelo(key, ciudadOrigen, ciudadDestino, fechaSalida, fechaArribe);
  }
}
