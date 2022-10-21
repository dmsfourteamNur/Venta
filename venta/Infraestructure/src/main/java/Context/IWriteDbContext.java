package Context;

import Model.Facturas.Factura;
import Model.Recibos.Recibo;
import Model.Ventas.Pago;
import Model.Ventas.Venta;
import Model.Ventas.VentaDetalle;
import Model.Vuelo.Vuelo;
import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) throws DataBaseException {
    super(dbContextClass);
  }

  public DbSet<Pago> Pago;
  public DbSet<Factura> Factura;
  public DbSet<Recibo> Recibo;
  public DbSet<Venta> Venta;
  public DbSet<VentaDetalle> VentaDetalle;
  public DbSet<Vuelo> Vuelo;
}
