package Dto;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class PagoDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    PagoDto pago = new PagoDto();

    Assert.assertEquals(null, pago.key);
    Assert.assertEquals(null, pago.descripcion);

    pago.key = key;
    pago.descripcion = nombre;

    Assert.assertEquals(key, pago.key);
    Assert.assertEquals(nombre, pago.descripcion);
  }
}
