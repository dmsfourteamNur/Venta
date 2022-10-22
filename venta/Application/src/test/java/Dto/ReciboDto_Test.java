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

public class ReciboDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    Date d = new Date();
    ReciboDto recibo = new ReciboDto(key, anyString(), anyString(), 523.50 , anyString());
    ReciboDto recibo2 = new ReciboDto();


  }
}
