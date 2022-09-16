package Repositories;

import Model.Ventas.Venta;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IVentaRepository extends IRepository<Venta, UUID> {
  public List<Venta> GetAll();

  public Venta Delete(Venta venta);

  public Venta Update(Venta venta);
}
