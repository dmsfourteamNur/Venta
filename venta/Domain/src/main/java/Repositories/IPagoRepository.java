package Repositories;

import core.IRepository;
import java.util.List;
import java.util.UUID;

import Model.Ventas.Pago;

public interface IPagoRepository extends IRepository<Pago, UUID> {
  public List<Pago> GetAll() throws Exception;

  public Pago Delete(Pago pago) throws Exception;

  public Pago Update(Pago pago) throws Exception;
}
