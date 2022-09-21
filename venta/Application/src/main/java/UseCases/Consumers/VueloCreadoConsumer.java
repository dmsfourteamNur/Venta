package UseCases.Consumers;

import Factories.IVueloFactory;
import Fourteam.massTransit.IConsumer;
import Fourteam.mediator.IMediator;
import Model.Vuelo.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class VueloCreadoConsumer extends IConsumer<IntegrationEvents.VueloCreado> {

  // public VueloCreadoConsumer(IMediator mediator) {
  // System.out.println("Entro al constructor del consumer");
  // }

  public static String QueueName = "vuelo-creado";

  private IVueloRepository _ivueloRepository;
  private IVueloFactory _ivuelorioFactory;
  private IUnitOfWork _unitOfWork;

  public VueloCreadoConsumer(IVueloRepository ivueloRepository, IVueloFactory ivueloFactory,
      IUnitOfWork _unitOfWork) {
    this._ivueloRepository = ivueloRepository;
    this._ivuelorioFactory = ivueloFactory;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public void Consume(IntegrationEvents.VueloCreado objeto) {
    // Vuelo vuelo = _ivuelorioFactory.Create(
    //     );

    for (var item : objeto.listaAsientos) {
      // vuelo.AgregarAsientos(item.getKey(), item.getNumero(), item.getDisponibilidad());
    }

    try {
      // _ivueloRepository.Create(vuelo);
      _unitOfWork.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
