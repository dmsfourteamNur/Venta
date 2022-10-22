package Event;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VentaCreadaTest {

	@Test
	public void test1() {


    VentaCreada constructor = new VentaCreada();

		UUID keyVenta = UUID.randomUUID();
		UUID keyVuelo = UUID.randomUUID();
		String nombre = "alvaro";
		String apellido = "soliz";
		String dni = "8943860sc";
    LocalDateTime fechaOn = LocalDateTime.now();

    VentaCreada ventaCreada = new VentaCreada(nombre, apellido, dni, keyVuelo, keyVenta);



   ventaCreada.setKeyVenta(keyVenta);
   ventaCreada.setKeyVuelo(keyVuelo);
   ventaCreada.setNombre(nombre);
   ventaCreada.setApellido(apellido);
   ventaCreada.setDni(dni);




		Assert.assertEquals(keyVenta, ventaCreada.getKeyVenta());
		Assert.assertEquals(keyVuelo, ventaCreada.getKeyVuelo());
		Assert.assertEquals(nombre, ventaCreada.getNombre());
		Assert.assertEquals(apellido, ventaCreada.getApellido());
		Assert.assertEquals(dni, ventaCreada.getDni());


	}

}
