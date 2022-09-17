import Context.IWriteDbContext;
import Repositories.*;
import Repository.*;
import UseCases.Consumers.VueloCreadoConsumer;
import Fourteam.config.Config;
import Fourteam.extensions.IServiceCollection;

public class Infraestructure {

  public static void AddInfraestructure() {
    IServiceCollection.AddMediator();
    IServiceCollection.AddScoped(
        IWriteDbContext.class,
        Context.MongoDB.WriteDbContext.class);
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(
        IPagoRepository.class,
        PagoRepository.class);

    IServiceCollection.AddScoped(IFacturaRepository.class, FacturaRepository.class);
    IServiceCollection.AddScoped(IVentaRepository.class, VentaRepository.class);
    IServiceCollection.AddScoped(IVentaDetalleRepository.class, VentaDetalleRepository.class);

    Application.AddApplication();
    AddRabbitMq();
  }

  private static void AddRabbitMq() {
    IServiceCollection.AddMassTransit(config -> {
      config.AddConsumer(VueloCreadoConsumer.class);

      config.UsingRabbitMq((context, cfg) -> {
        cfg.Host = Config.getProperty("rabit.host");
        cfg.User = Config.getProperty("rabit.user");
        cfg.Password = Config.getProperty("rabit.pass");
      });
    });
  }
}
