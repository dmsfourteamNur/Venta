import Controllers.PagoController;
import Controllers.FacturaController;
import Controllers.VentaController;
import Fourteam.config.Config;
import Fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(PagoController.class);
    Rest.addController(FacturaController.class);
    Rest.addController(VentaController.class);
    Rest.start(Integer.parseInt(Config.getProperty("http.port")));
    Rest.createSwagger();
  }
}
