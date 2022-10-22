package Model.Facturas;


import java.time.LocalDateTime;
 import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class FacturaTest {

  @Test
  public void constructor_accept() {

    UUID keyVenta = UUID.randomUUID();
    String nit = "8943851sc";
    String razonSocial = "alvaro siles";
    Double monto = 550.00;
    Integer estado = 1;
    String detalle = "Nro. 3534651";
    LocalDateTime fechaOn = LocalDateTime.now();

    Factura a = new Factura(keyVenta, nit, razonSocial, monto, razonSocial);
    Assert.assertEquals(a.keyVenta, keyVenta);
    Assert.assertEquals(a.nit, nit);
    Assert.assertEquals(a.razonSocial, razonSocial);
    Assert.assertEquals(a.monto, monto);
    Assert.assertEquals(a.estado, estado);
    // Assert.assertEquals(a.detalle, detalle);
    // Assert.assertEquals(a.fechaOn, fechaOn);

    a.setKeyVenta(keyVenta);
    a.setNit(nit);
    a.setRazonSocial(razonSocial);
    a.setMonto(monto);
    a.setEstado(estado);
    a.setFechaOn(fechaOn);
  }

}
