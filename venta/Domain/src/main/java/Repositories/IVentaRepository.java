package Repositories;

import Model.Ventas.Venta;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IVentaRepository extends IRepository<Venta, UUID> {
  public List<Venta> GetAll() throws Exception;

  public Venta Delete(Venta venta) throws Exception;

  public Venta Update(Venta venta) throws Exception;
}
