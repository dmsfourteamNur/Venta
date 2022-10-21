package Repository;

import Context.IWriteDbContext;
import Model.Ventas.Pago;
import Model.Vuelo.Tarifa;
import Model.Vuelo.Vuelo;
import Repositories.IPagoRepository;
import Repositories.IVueloRepository;
import Repositories.IVueloRepository;
import Fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class VueloRepository implements IVueloRepository {

  private DbSet<Vuelo> _vuelos;

  public VueloRepository(IWriteDbContext database) {
    _vuelos = database.Vuelo;
  }

  @Override
  public Vuelo FindByKey(UUID key) throws Exception {
    return _vuelos.Single(obj -> obj.key.equals(key));
  }


  @Override
  public void Create(Vuelo obj) throws Exception {
    _vuelos.Add(obj);
  }

  @Override
  public List<Vuelo> GetAll() throws Exception {
    return _vuelos.All();
  }

  @Override
  public Vuelo Delete(Vuelo obj) throws Exception {
    _vuelos.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Vuelo Update(Vuelo obj) throws Exception {
    _vuelos.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
