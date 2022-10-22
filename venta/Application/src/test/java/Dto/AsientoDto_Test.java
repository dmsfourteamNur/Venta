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

public class AsientoDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    Date d = new Date();
    AsientoDto asiento = new AsientoDto(key, anyInt(), anyString());
    AsientoDto asiento2 = new AsientoDto();

    Assert.assertEquals("", asiento.getClase());
    Assert.assertEquals(key, asiento.getKeyAeronave());
    Assert.assertEquals(0, asiento.getNumero());
    // Assert.assertEquals("", asiento.getClass());

    asiento.setClase(null);
    asiento.setKeyAeronave(null);
    asiento.setNumero(anyInt());


    // Assert.assertEquals(key, asiento.key);
    // Assert.assertEquals(nombre, asiento.descripcion);
  }
}
