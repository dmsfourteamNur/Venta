package UseCases.Queries.Vuelo.GetAll;

import Fourteam.mediator.RequestHandler;
// import Model.Tripulacion.Tripulacion;
// import Model.Tripulante.Cargo;
import Model.Vuelo.Tarifa;
import Model.Vuelo.Vuelo;
// import Repositories.ICargoRepository;
// import Repositories.ITripulacionRepository;
import Repositories.IVueloRepository;

import java.util.List;

public class GetAllVueloHandler
	implements RequestHandler<GetAllVueloQuery, List<Vuelo>> {

	private IVueloRepository _vueloRepository;

	public GetAllVueloHandler(
		IVueloRepository vueloRepository
	) {
		this._vueloRepository = vueloRepository;
	}

	@Override
	public List<Vuelo> handle(GetAllVueloQuery request)
		throws Exception {
		return _vueloRepository.GetAll();
	}
}
