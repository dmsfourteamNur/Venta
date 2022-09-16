import Context.IWriteDbContext;
import Repositories.*;
import Repository.*;
import fourteam.extensions.IServiceCollection;

public class Infraestructure {

  public static void AddInfraestructure() {
    IServiceCollection.AddMediator();
    IServiceCollection.AddScoped(
      IWriteDbContext.class,
      Context.MongoDB.WriteDbContext.class
    );
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(
      IPagoRepository.class,
      PagoRepository.class
    );

    IServiceCollection.AddScoped(IFacturaRepository.class, FacturaRepository.class);
    IServiceCollection.AddScoped(IVentaRepository.class, VentaRepository.class);
    IServiceCollection.AddScoped(IVentaDetalleRepository.class, VentaDetalleRepository.class);


    Application.AddApplication();
  }
}
