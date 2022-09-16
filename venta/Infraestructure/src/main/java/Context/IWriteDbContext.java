package Context;

import Model.Facturas.Factura;
import Model.Pagos.Pago;
import Model.Ventas.Venta;
import Model.Ventas.VentaDetalle;
import fourteam.db.DbContext;
import fourteam.db.DbSet;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) {
    super(dbContextClass);
  }

  public DbSet<Pago> Pago;
  public DbSet<Factura> Factura;
  public DbSet<Venta> Venta;
  public DbSet<VentaDetalle> VentaDetalle;
}
