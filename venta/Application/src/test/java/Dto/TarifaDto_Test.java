package Dto;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.UUID;
import org.junit.Test;


public class TarifaDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    TarifaDto venta = new TarifaDto(key, anyString(), anyDouble(), anyInt());

  }
}
