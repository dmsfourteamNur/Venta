package Repository;

import Context.IWriteDbContext;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import Fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class PagoRepository implements IPagoRepository {

  private DbSet<Pago> _pagos;

  public PagoRepository(IWriteDbContext database) {
    _pagos = database.Pago;
  }

  @Override
  public Pago FindByKey(UUID key) throws Exception {
    return _pagos.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Pago obj) throws Exception {
    _pagos.Add(obj);
  }

  @Override
  public List<Pago> GetAll() throws Exception {
    return _pagos.All();
  }

  @Override
  public Pago Delete(Pago obj) throws Exception {
    _pagos.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Pago Update(Pago obj) throws Exception {
    _pagos.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
