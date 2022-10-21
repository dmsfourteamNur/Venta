package UseCases.Command.Vuelo.AddTarifa;

import java.util.UUID;

import Factories.IVueloFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Vuelo.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class AddTarifaVueloHanlder implements RequestHandler<AddTarifaVueloCommand, UUID> {

  private IVueloFactory _VueloFactory;
  private IVueloRepository _VueloRepository;
  private IUnitOfWork _unitOfWork;

  public AddTarifaVueloHanlder(
      IVueloFactory _VueloFactory,
      IVueloRepository _VueloRepository,
      IUnitOfWork _unitOfWork) {
    this._VueloFactory = _VueloFactory;
    this._VueloRepository = _VueloRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(AddTarifaVueloCommand request) throws Exception {
    Vuelo vuelo = _VueloRepository.FindByKey(request.key);
    if (vuelo == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo Not found");
    }

    UUID key_tarifa = UUID.randomUUID();
    vuelo.AgregarTarifa(key_tarifa, request.data.descripcion, request.data.precio, request.data.cantidad);
    _VueloRepository.Update(vuelo);
    _unitOfWork.commit();
    return vuelo.key;

  }
}
