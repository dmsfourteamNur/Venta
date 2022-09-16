package Repository;

import Context.IWriteDbContext;
import Model.Pagos.Pago;
import Model.Ventas.Venta;
import Model.Ventas.VentaDetalle;
import Repositories.IPagoRepository;
import Repositories.IVentaDetalleRepository;
import Repositories.IVentaRepository;
import fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class VentaDetalleRepository implements IVentaDetalleRepository {

  private DbSet<VentaDetalle> _ventasDetalle;

  public VentaDetalleRepository(IWriteDbContext database) {
    _ventasDetalle = database.VentaDetalle;
  }

  @Override
  public VentaDetalle FindByKey(UUID key) {
    return _ventasDetalle.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(VentaDetalle obj) {
    _ventasDetalle.Add(obj);
  }




}
