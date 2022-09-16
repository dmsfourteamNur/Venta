package Repository;

import Context.IWriteDbContext;
import Model.Pagos.Pago;
import Model.Ventas.Venta;
import Repositories.IPagoRepository;
import Repositories.IVentaRepository;
import fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class VentaRepository implements IVentaRepository {

  private DbSet<Venta> _ventas;

  public VentaRepository(IWriteDbContext database) {
    _ventas = database.Venta;
  }

  @Override
  public Venta FindByKey(UUID key) {
    return _ventas.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Venta obj) {
    _ventas.Add(obj);
  }

  @Override
  public List<Venta> GetAll() {
    return _ventas.All();
  }

  @Override
  public Venta Delete(Venta obj) {
    _ventas.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Venta Update(Venta obj) {
    _ventas.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
