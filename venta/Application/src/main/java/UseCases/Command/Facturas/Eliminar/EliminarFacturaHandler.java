package UseCases.Command.Facturas.Eliminar;

import Factories.IPagoFactory;
import Factories.IFacturaFactory;
import Model.Facturas.Factura;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import Repositories.IFacturaRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class EliminarFacturaHandler
  implements RequestHandler<EliminarFacturaCommand, Factura> {

  private IFacturaFactory _facturaFactory;
  private IFacturaRepository _facturaRepository;
  private IUnitOfWork _unitOfWork;

  public EliminarFacturaHandler(
    IFacturaFactory facturaFactory,
    IFacturaRepository facturaRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._facturaFactory = facturaFactory;
    this._facturaRepository = facturaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Factura handle(EliminarFacturaCommand request) throws Exception {
    Factura factura = _facturaRepository.FindByKey(request.factura.key);
    if (factura == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Factura no encontrada");
    }

    return _facturaRepository.Delete(factura);
  }
}
