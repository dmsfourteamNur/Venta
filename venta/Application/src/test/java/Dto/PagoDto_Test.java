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
    PagoDto pago2 = new PagoDto(nombre, key, "", 150.0);

    Assert.assertEquals(null, pago.getKey());
    Assert.assertEquals(null, pago.getDescripcion());
    Assert.assertEquals(null, pago.getKeyVenta());

    pago.setKey(key);
    pago.setDescripcion(nombre);
    pago.setKeyVenta(key);

    Assert.assertEquals(key, pago.key);
    Assert.assertEquals(nombre, pago.descripcion);
  }
}
