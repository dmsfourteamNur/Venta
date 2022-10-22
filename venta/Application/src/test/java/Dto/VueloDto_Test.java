package Dto;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;

public class VueloDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    Date d = new Date();
    VueloDto vuelo = new VueloDto(key, anyString(), anyString(), d , d);

    Assert.assertEquals("", vuelo.getCiudadDestino());
    Assert.assertEquals("", vuelo.getCiudadOrigen());
    Assert.assertEquals(new ArrayList<>(), vuelo.getAsiento());
    Assert.assertEquals(d, vuelo.getFechaArribe());
    Assert.assertEquals(d, vuelo.getFechaSalida());
    // Assert.assertEquals("", vuelo.getTarifas());

    vuelo.setAsiento(null);
    vuelo.setCiudadDestino(null);
    vuelo.setCiudadOrigen(anyString());
    vuelo.setFechaArribe(d);
    vuelo.setFechaSalida(d);
    vuelo.setTarifas(null);


    // Assert.assertEquals(key, vuelo.key);
    // Assert.assertEquals(nombre, vuelo.descripcion);
  }
}
