package Repositories;

import core.IRepository;
import java.util.List;
import java.util.UUID;

import Model.Vuelo.Vuelo;

public interface IVueloRepository extends IRepository<Vuelo, UUID> {
  public List<Vuelo> GetAll();

  public Vuelo Delete(Vuelo vuelo);

  public Vuelo Update(Vuelo vuelo);
}
