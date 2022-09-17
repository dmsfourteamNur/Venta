import Factories.PagoFactory;
import Factories.IPagoFactory;
import Factories.IFacturaFactory;
import Factories.IVentaFactory;
import Factories.FacturaFactory;
import Factories.VentaFactory;
import UseCases.Command.Facturas.Crear.CrearFacturaHandler;
import UseCases.Command.Facturas.Editar.EditarFacturaHandler;
import UseCases.Command.Facturas.Eliminar.EliminarFacturaHandler;
import UseCases.Command.Pagos.Crear.CrearPagoHandler;
import UseCases.Command.Pagos.Editar.EditarPagoHandler;
import UseCases.Command.Pagos.Eliminar.EliminarPagoHandler;
import UseCases.Command.Ventas.Crear.CrearVentaHandler;
import UseCases.Command.Ventas.Editar.EditarVentaHandler;
import UseCases.Command.Ventas.Eliminar.EliminarVentaHandler;
import UseCases.Queries.Facturas.GetAll.GetAllFacturaHandler;
import UseCases.Queries.Facturas.GetByKey.GetFacturaByKeyHandler;
import UseCases.Queries.Pagos.GetAll.GetAllPagoHandler;
import UseCases.Queries.Pagos.GetByKey.GetPagoByKeyHandler;
import UseCases.Queries.Ventas.GetAll.GetAllVentaHandler;
import UseCases.Queries.Ventas.GetByKey.GetVentaByKeyHandler;
import Fourteam.extensions.IServiceCollection;
import Fourteam.mediator.IMediator;

public class Application {

  public static void AddApplication() {
    // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring

    IMediator.registerHandler(GetAllPagoHandler.class);
    IMediator.registerHandler(GetPagoByKeyHandler.class);
    IMediator.registerHandler(CrearPagoHandler.class);
    IMediator.registerHandler(EliminarPagoHandler.class);
    IMediator.registerHandler(EditarPagoHandler.class);
    // MARCA
    IMediator.registerHandler(GetAllFacturaHandler.class);
    IMediator.registerHandler(GetFacturaByKeyHandler.class);
    IMediator.registerHandler(CrearFacturaHandler.class);
    IMediator.registerHandler(EliminarFacturaHandler.class);
    IMediator.registerHandler(EditarFacturaHandler.class);
    //VENTA
    IMediator.registerHandler(GetAllVentaHandler.class);
    IMediator.registerHandler(GetVentaByKeyHandler.class);
    IMediator.registerHandler(CrearVentaHandler.class);
    IMediator.registerHandler(EliminarVentaHandler.class);
    IMediator.registerHandler(EditarVentaHandler.class);

    IServiceCollection.AddTransient(
      IPagoFactory.class,
      PagoFactory.class
    );
    IServiceCollection.AddTransient(IFacturaFactory.class, FacturaFactory.class);
    IServiceCollection.AddTransient(IVentaFactory.class, VentaFactory.class);

    Domain.addDomain();
  }
}
