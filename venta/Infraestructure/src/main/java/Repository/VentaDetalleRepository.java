package Repository;

import Context.IWriteDbContext;
import Model.Ventas.Pago;
import Model.Ventas.Venta;
import Model.Ventas.VentaDetalle;
import Repositories.IPagoRepository;
import Repositories.IVentaDetalleRepository;
import Repositories.IVentaRepository;
import Fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class VentaDetalleRepository implements IVentaDetalleRepository {

  private DbSet<VentaDetalle> _ventasDetalle;

  public VentaDetalleRepository(IWriteDbContext database) {
    _ventasDetalle = database.VentaDetalle;
  }

  @Override
  public VentaDetalle FindByKey(UUID key) throws Exception {
    return _ventasDetalle.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(VentaDetalle obj) throws Exception {
    _ventasDetalle.Add(obj);
  }

}
