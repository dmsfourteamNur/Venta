package Model.Vuelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VueloTest {



  @Test
    public void testAgregarAsientos() {

      UUID key = UUID.randomUUID();
      String origen = "scz";
      String destino = " cbba";
      Date fechaSalida   = new Date();
      Date fechaArribe   = new Date();
      List<Asiento> asiento = new ArrayList<>();
      List<Tarifa> tarifas = new ArrayList<>();

      Vuelo a = new Vuelo(key, origen, destino, fechaSalida, fechaArribe);


      Assert.assertEquals(a.getCiudadOrigen(), origen);
      Assert.assertEquals(a.getCiudadDestino(), destino);
      Assert.assertEquals(a.getFechaSalida(), fechaSalida);
      Assert.assertEquals(a.getFechaArribe(), fechaArribe);
      Assert.assertEquals(a.getAsiento(), asiento);
      Assert.assertEquals(a.getTarifas(), tarifas);

      a.setCiudadDestino(destino);
      a.setCiudadDestino(destino);
      a.setFechaSalida(fechaSalida);
      a.setFechaArribe(fechaArribe);
      a.setAsiento(asiento);
      a.setTarifas(tarifas);


    }
}
