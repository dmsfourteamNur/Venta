package Model.Ventas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VentaTest {

  // @Test
  public void constructor_accept() {

    String nombre = "alvaro";
    String apellido = " siles";
    String dni = "8943861";
    UUID KeyVuelo = UUID.randomUUID();
    UUID keyTarifa = UUID.randomUUID();
    Integer estadoVenta = 1;
    LocalDateTime fechaOn = LocalDateTime.now();
    Integer estado = 1;
    Double monto = 100.1;
    List<Pago> pagos = new ArrayList<>();

    Venta a = new Venta(nombre, apellido, dni, KeyVuelo, keyTarifa, monto);

    Assert.assertEquals(a.nombre, nombre);
    Assert.assertEquals(a.apellido, apellido);
    Assert.assertEquals(a.dni, dni);
    Assert.assertEquals(a.keyVuelo, KeyVuelo);
    Assert.assertEquals(a.keyTarifa, keyTarifa);
    // Assert.assertEquals(a.estadoVenta, estadoVenta);
    // Assert.assertEquals(a.fechaOn, fechaOn);
    Assert.assertEquals(a.estado, estado);
    // Assert.assertEquals(a.monto, monto);
    Assert.assertEquals(a.pagos, pagos);

    // a.se(keyVenta);
    // a.setNit(dni);
    // a.setRazonSocial(nombre);
    // a.setMonto(monto);
    a.setEstado(estado);
    a.setFechaOn(fechaOn);
  }
}
