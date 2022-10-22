package Factories;

import java.util.UUID;

import org.junit.Test;

 import Model.Facturas.Factura;

public class FacturaFactoryTest {
	@Test
	public void dataValid() {
		FacturaFactory aeronaveFactory = new FacturaFactory();
		Factura aeronave = aeronaveFactory.Create(null, null, null, null, null);
		System.out.println(aeronave);
	}
}
