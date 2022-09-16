import Controllers.PagoController;
import Controllers.FacturaController;
import Controllers.VentaController;
import fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(PagoController.class);
    Rest.addController(FacturaController.class);
    Rest.addController(VentaController.class);
    Rest.start(8080);
    Rest.createSwagger();
  }
}
