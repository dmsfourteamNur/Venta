package Dto;

import static org.mockito.ArgumentMatchers.anyString;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

import Model.Ventas.Venta;

public class VentaDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    VentaDto venta = new VentaDto();
    VentaDto venta2 = new VentaDto( key,anyString(),anyString(),anyString(), UUID.randomUUID(),UUID.randomUUID(), 150.0);
    Venta ventaO = new Venta(anyString(),anyString(),anyString(), UUID.randomUUID(),UUID.randomUUID(), 150.0);
    VentaDto venta3 = new VentaDto(ventaO);
    VentaDto venta4 = new VentaDto(key, anyString(),anyString(), anyString(), key, key);

    Assert.assertEquals(null, venta.getKey());
    Assert.assertEquals(null, venta.getNombre());
    Assert.assertEquals(null, venta.getApellido());
    Assert.assertEquals(null, venta.getDni());
    Assert.assertEquals(null, venta.getKeyTarifa());
    Assert.assertEquals(null, venta.getKeyVuelo());
    // Assert.assertEquals(150.0, venta2.getMonto());


    venta.setKey(key);
    venta.setNombre(nombre);
    venta.setApellido("Estrada");
    venta.setDni("6356522");
    venta.setKeyTarifa(key);
    venta.setKeyVuelo(key);
    venta.setMonto(456.0);
    venta.setPagos(null);


  }
}
