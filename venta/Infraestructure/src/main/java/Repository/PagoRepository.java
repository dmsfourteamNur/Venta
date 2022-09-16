package Repository;

import Context.IWriteDbContext;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class PagoRepository implements IPagoRepository {

  private DbSet<Pago> _pagos;

  public PagoRepository(IWriteDbContext database) {
    _pagos = database.Pago;
  }

  @Override
  public Pago FindByKey(UUID key) {
    return _pagos.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Pago obj) {
    _pagos.Add(obj);
  }

  @Override
  public List<Pago> GetAll() {
    return _pagos.All();
  }

  @Override
  public Pago Delete(Pago obj) {
    _pagos.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Pago Update(Pago obj) {
    _pagos.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
