package Factories;

import java.util.Date;
import java.util.UUID;

import Model.Vuelo.Vuelo;

public interface IVueloFactory {
  Vuelo Create(
      UUID key,
      String origen,
      String destino,
      Date fechaSalida,
      Date fechaArribe);
}
