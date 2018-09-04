package br.com.souto.registry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.souto.repository.RegistersIds;

public class SalesManRegistryTest {

	@Test public void validateInputLines () {
		assertTrue(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Pedro\u00E750000"));
		assertTrue(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E79456"));
		assertTrue(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E79456.30"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E79456,30"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E79456..30"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E79456.0"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E794560R"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E7R79456"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E7.79456"));

		assertTrue(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Antonio Souto\u00E79456.30"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Antonio Souto 3\u00E79456.30"));
		
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E7123.456.789/1234\u00E7Antonio Souto\u00E79456.30"));
		
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E71234567891234\u00E7Antonio Souto\u00E79456.30"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E71234567891234\u00E7Antonio Souto\u00E79456.30"));
		assertFalse(SalesManRegistry.validateInputLine("\u00E71234567891234\u00E7Antonio Souto\u00E79456.30"));
		
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E79456\u00E7"));
		assertFalse(SalesManRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E71234567891234\u00E7Name\u00E79456\u00E7too much info"));

	}
	
}
