package Repository;

import Context.IWriteDbContext;
import Model.Facturas.Factura;
import Repositories.IFacturaRepository;
import Fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class FacturaRepository implements IFacturaRepository {

  private DbSet<Factura> _facturas;

  public FacturaRepository(IWriteDbContext database) {
    _facturas = database.Factura;
  }

  @Override
  public Factura FindByKey(UUID key) throws Exception {
    return _facturas.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Factura obj) throws Exception {
    _facturas.Add(obj);
  }

  @Override
  public List<Factura> GetAll() throws Exception {
    return _facturas.All();
  }

  @Override
  public Factura Delete(Factura obj) throws Exception {
    _facturas.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Factura Update(Factura obj) throws Exception {
    _facturas.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
