package UseCases.Command.Pagos.Crear;

import java.util.UUID;

import Factories.IFacturaFactory;
import Factories.IPagoFactory;
import Factories.IReciboFactory;
import Model.Facturas.Factura;
import Model.Recibos.Recibo;
import Model.Ventas.Pago;
import Model.Ventas.Venta;
import Repositories.IFacturaRepository;
import Repositories.IPagoRepository;
import Repositories.IReciboRepository;
import Repositories.IUnitOfWork;
import Repositories.IVentaRepository;
import Fourteam.console.console;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;

public class CrearPagoHandler
    implements RequestHandler<CrearPagoCommand, String> {

  private IPagoFactory _pagoFactory;
  private IFacturaFactory _FacturaFactory;
  private IFacturaRepository _FacturaRepository;
  private IPagoRepository _pagoRepository;
  private IVentaRepository _VentaRepository;
  private IReciboFactory _ReciboFactory;
  private IReciboRepository _ReciboRepository;

  private IUnitOfWork _unitOfWork;

  public CrearPagoHandler(
      IPagoFactory pagoFactory,
      IPagoRepository pagoRepository,
      IFacturaFactory facturaFactory,
      IFacturaRepository facturaRepository,
      IVentaRepository ventaRepository,
      IReciboFactory reciboFactory,
      IReciboRepository reciboRepository,
      IUnitOfWork _unitOfWork) {
    this._pagoFactory = pagoFactory;
    this._pagoRepository = pagoRepository;
    this._VentaRepository = ventaRepository;
    this._FacturaFactory = facturaFactory;
    this._FacturaRepository = facturaRepository;
    this._ReciboRepository = reciboRepository;
    this._ReciboFactory = reciboFactory;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public String handle(CrearPagoCommand request) throws Exception {

    Venta venta = _VentaRepository.FindByKey(request.data.keyVenta);
    if (venta == null)
      throw new HttpException(404, "No existe la venta");

    if (request.data.monto <= 0) {
      throw new HttpException(404, "El pago debe ser mayor a 0");
    }

    Pago pago = _pagoFactory.Create(request.data.descripcion, request.data.keyVenta, request.data.monto,
        request.data.tipo);
    venta.pagos.add(pago);

    double total_pagado = 0;
    double monto = venta.monto;
    for (Pago o : venta.pagos) {
      total_pagado += o.monto;
    }

    double porcentaje_pagado = total_pagado / monto;
    console.log("Precio de la venta =", monto, " total_pagado=", total_pagado);
    if (porcentaje_pagado >= 1) {
      venta.eventCreado();
      _VentaRepository.Update(venta);
      Factura fact = _FacturaFactory.Create(venta.key, venta.dni, venta.nombre, monto,
          "Factura por la compra del pasaje.");
      _FacturaRepository.Create(fact);
      _unitOfWork.commit();
      console.warning("SE ENTREGO LA FACTURA POR EL PAGO DE MAS DEL 100% DEL PASAJE");
      return "SE ENTREGO LA FACTURA POR EL PAGO DE MAS DEL 100% DEL PASAJE, Total pagado (" + (monto - total_pagado)
          + ")";
    } else if (porcentaje_pagado >= 0.5) {
      _VentaRepository.Update(venta);
      Recibo fact = _ReciboFactory.Create(venta.key, venta.dni, venta.nombre, pago.monto,
          "Recibo por la compra del pasaje.");
      _ReciboRepository.Create(fact);
      _unitOfWork.commit();
      console.warning("SE PAGO MAS DEL 50% DEL PASAJE");
      return "SE ENTREGO UN RECIBO POR PAGO DE MAS DEL 50% DEL PASAJE, Deuda pendiente (" + (monto - total_pagado)
          + ")";
    }
    _VentaRepository.Update(venta);
    _unitOfWork.commit();
    return "SE PAGO MENOS DEL 50% DEL PASAJE " + (monto - total_pagado);
  }
}
