package Repository;

import Context.IWriteDbContext;
import Model.Facturas.Factura;
import Repositories.IFacturaRepository;
import fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class FacturaRepository implements IFacturaRepository {

  private DbSet<Factura> _facturas;

  public FacturaRepository(IWriteDbContext database) {
    _facturas = database.Factura;
  }

  @Override
  public Factura FindByKey(UUID key) {
    return _facturas.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Factura obj) {
    _facturas.Add(obj);
  }

  @Override
  public List<Factura> GetAll() {
    return _facturas.All();
  }

  @Override
  public Factura Delete(Factura obj) {
    _facturas.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Factura Update(Factura obj) {
    _facturas.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
