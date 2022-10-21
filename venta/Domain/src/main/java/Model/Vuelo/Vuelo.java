package Model.Vuelo;

import core.AggregateRoot;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Vuelo extends AggregateRoot<UUID> {
  private String origen;
  private String destino;
  private Date fechaSalida;
  private Date fechaArribe;
  private List<Asiento> asiento;
  private List<Tarifa> tarifas;

  public Vuelo(
      UUID keyVuelo,
      String ciudadOrigen,
      String ciudadDestino,
      Date fechaSalida,
      Date fechaArribe) {
    this.key = keyVuelo;
    this.origen = ciudadOrigen;
    this.destino = ciudadDestino;
    this.fechaArribe = fechaArribe;
    this.fechaSalida = fechaSalida;
    this.asiento = new ArrayList<Asiento>();
    this.tarifas = new ArrayList<Tarifa>();
  }

  public void AgregarAsientos(UUID key, int numeroAsiento, int disponibilidad, double precio) {
    Asiento asientos = new Asiento(key, numeroAsiento, disponibilidad, precio);
    asiento.add(asientos);
  }

  public void AgregarTarifa(UUID key, String descripcion, double precio, int cantidad) {
    Tarifa tarifa = new Tarifa(key, descripcion, precio, cantidad);
    this.tarifas.add(tarifa);
  }

  public String getCiudadOrigen() {
    return this.origen;
  }

  public void setCiudadOrigen(String ciudadOrigen) {
    this.origen = ciudadOrigen;
  }

  public String getCiudadDestino() {
    return this.destino;
  }

  public void setCiudadDestino(String destino) {
    this.destino = destino;
  }

  public Date getFechaSalida() {
    return this.fechaSalida;
  }

  public void setFechaSalida(Date fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  public Date getFechaArribe() {
    return this.fechaArribe;
  }

  public void setFechaArribe(Date fechaArribe) {
    this.fechaArribe = fechaArribe;
  }

  public List<Asiento> getAsiento() {
    return this.asiento;
  }

  public void setAsiento(List<Asiento> asiento) {
    this.asiento = asiento;
  }

  public List<Tarifa> getTarifas() {
    return tarifas;
  }

  public void setTarifas(List<Tarifa> tarifas) {
    this.tarifas = tarifas;
  }
}
