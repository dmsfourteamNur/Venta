package UseCases.Command.Facturas.Editar;

import Factories.IPagoFactory;
import Factories.IFacturaFactory;
import Model.Facturas.Factura;
import Model.Pagos.Pago;
import Repositories.IPagoRepository;
import Repositories.IFacturaRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EditarFacturaHandler
  implements RequestHandler<EditarFacturaCommand, Factura> {

  private IFacturaFactory _facturaFactory;
  private IFacturaRepository _facturaRepository;
  private IUnitOfWork _unitOfWork;

  public EditarFacturaHandler(
    IFacturaFactory facturaFactory,
    IFacturaRepository facturaRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._facturaFactory = facturaFactory;
    this._facturaRepository = facturaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Factura handle(EditarFacturaCommand request) throws HttpException {
    Factura factura = _facturaRepository.FindByKey(request.factura.key);
    if (factura == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Factura no encontrada");
    }
    factura.nit = request.factura.nit;
    _facturaRepository.Update(factura);
    return factura;
  }
}
