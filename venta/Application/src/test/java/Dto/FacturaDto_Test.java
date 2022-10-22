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

public class FacturaDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    FacturaDto factura = new FacturaDto(key, anyString(), anyString(), 523.50 , anyString());
    FacturaDto factura2 = new FacturaDto();


  }
}
