package Repository;

import Context.IWriteDbContext;
import Model.Pagos.Pago;
import Model.Ventas.Venta;
import Repositories.IPagoRepository;
import Repositories.IVentaRepository;
import Fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class VentaRepository implements IVentaRepository {

  private DbSet<Venta> _ventas;

  public VentaRepository(IWriteDbContext database) {
    _ventas = database.Venta;
  }

  @Override
  public Venta FindByKey(UUID key) throws Exception {
    return _ventas.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Venta obj) throws Exception {
    _ventas.Add(obj);
  }

  @Override
  public List<Venta> GetAll() throws Exception {
    return _ventas.All();
  }

  @Override
  public Venta Delete(Venta obj) throws Exception {
    _ventas.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Venta Update(Venta obj) throws Exception {
    _ventas.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
