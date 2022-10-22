package Model.Recibos;

import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class ReciboTest {




  // @Test
  public void constructor_accept() {

    UUID keyVenta = UUID.randomUUID();
    String nit = "8943851sc";
    String razonSocial = "alvaro siles";
    Double monto = 550.00;
    String detalle = "nro. 5465165";
    Integer estado = 1;

    Recibo a = new Recibo(keyVenta, nit, razonSocial, monto, detalle);
    Assert.assertEquals(a.keyVenta, keyVenta);
    Assert.assertEquals(a.nit, nit);
    Assert.assertEquals(a.razonSocial, razonSocial);
    Assert.assertEquals(a.monto, monto);
    Assert.assertEquals(a.estado, estado);
    Assert.assertEquals(a.detalle, detalle);
    Assert.assertEquals(a.fechaOn, any());
  }


}
