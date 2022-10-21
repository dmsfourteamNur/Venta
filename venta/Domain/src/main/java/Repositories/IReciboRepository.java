package Repositories;

import core.IRepository;
import java.util.List;
import java.util.UUID;

import Model.Recibos.Recibo;

public interface IReciboRepository extends IRepository<Recibo, UUID> {
  public List<Recibo> GetAll() throws Exception;

  public Recibo Delete(Recibo obj) throws Exception;

  public Recibo Update(Recibo obj) throws Exception;
}
