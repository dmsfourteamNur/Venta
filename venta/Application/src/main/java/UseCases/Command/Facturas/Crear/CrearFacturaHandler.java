package UseCases.Command.Facturas.Crear;

import Factories.IFacturaFactory;
import Model.Facturas.Factura;
import Repositories.IFacturaRepository;
import Repositories.IUnitOfWork;
import Fourteam.mediator.RequestHandler;

public class CrearFacturaHandler
    implements RequestHandler<CrearFacturaCommand, Factura> {

  private IFacturaFactory _facturaFactory;
  private IFacturaRepository _facturaRepository;
  private IUnitOfWork _unitOfWork;

  public CrearFacturaHandler(
      IFacturaFactory facturaFactory,
      IFacturaRepository facturaRepository,
      IUnitOfWork _unitOfWork) {
    this._facturaFactory = facturaFactory;
    this._facturaRepository = facturaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Factura handle(CrearFacturaCommand request) throws Exception {
    Factura factura = _facturaFactory.Create(request.keyVenta, request.nit, request.razonSocial, request.monto,
        request.detalle);
    _facturaRepository.Create(factura);
    _unitOfWork.commit();
    return factura;
  }
}
