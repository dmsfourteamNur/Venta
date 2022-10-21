package Repository;

import Context.IWriteDbContext;
import Model.Recibos.Recibo;
import Repositories.IReciboRepository;
import Fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class ReciboRepository implements IReciboRepository {

  private DbSet<Recibo> _recibos;

  public ReciboRepository(IWriteDbContext database) {
    _recibos = database.Recibo;
  }

  @Override
  public Recibo FindByKey(UUID key) throws Exception {
    return _recibos.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Recibo obj) throws Exception {
    _recibos.Add(obj);
  }

  @Override
  public List<Recibo> GetAll() throws Exception {
    return _recibos.All();
  }

  @Override
  public Recibo Delete(Recibo obj) throws Exception {
    _recibos.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Recibo Update(Recibo obj) throws Exception {
    _recibos.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
