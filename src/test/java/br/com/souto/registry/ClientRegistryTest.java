package br.com.souto.registry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.souto.repository.RegistersIds;

public class ClientRegistryTest {

	@Test public void validateInputLines () {
		assertTrue(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E72345675434544345\u00E7Jose da Silva\u00E7Rural"));
		assertTrue(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234567\u00E7Name\u00E7Rural II"));
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234567\u00E7Name\u00E7Rural 2"));
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234567\u00E7Name\u00E79Bla"));

		assertFalse(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234567\u00E7Antonio Souto 3\u00E7Urbano"));
		
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E712.345.678.91/1000\u00E7Antonio Souto\u00E7Urbano"));
		
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234567\u00E7Antonio Souto\u00E7Rural"));
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E71234567891234567\u00E7Antonio Souto\u00E7Rural"));
		assertFalse(ClientRegistry.validateInputLine("\u00E71234567891234567\u00E7Antonio Souto\u00E7Rural"));
		
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234567\u00E7Name"));
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234567\u00E7Name\u00E7Rural\u00E7"));
		assertFalse(ClientRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234567\u00E7Name\u00E7Rural\u00E7too much info"));

	}
	
}
