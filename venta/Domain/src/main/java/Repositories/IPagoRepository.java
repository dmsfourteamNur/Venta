package Repositories;

import core.IRepository;
import java.util.List;
import java.util.UUID;

import Model.Pagos.Pago;

public interface IPagoRepository extends IRepository<Pago, UUID> {
  public List<Pago> GetAll();

  public Pago Delete(Pago pago);

  public Pago Update(Pago pago);
}
