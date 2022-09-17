package Repositories;

import core.IRepository;
import java.util.List;
import java.util.UUID;

import Model.Facturas.Factura;

public interface IFacturaRepository extends IRepository<Factura, UUID> {
  public List<Factura> GetAll() throws Exception;

  public Factura Delete(Factura obj) throws Exception;

  public Factura Update(Factura obj) throws Exception;
}
