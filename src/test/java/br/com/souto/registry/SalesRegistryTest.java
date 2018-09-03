package br.com.souto.registry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.souto.repository.RegistersIds;

public class SalesRegistryTest {

	@Test public void validateInputLines () {
		assertTrue(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1-10-100,2-30-2.50,3-40-3.10]\u00E7Pedro"));
		assertTrue(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[3-40-3.10]\u00E7Pedro"));
		assertTrue(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1-10-100]\u00E7Pedro"));
		assertTrue(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1-10-100]\u00E7Pedro Alberto"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1-10-100]\u00E7Pedro Alberto 1"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701a\u00E7[1-10-100]\u00E7Pedro Alberto"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[-10-100]\u00E7Pedro Alberto"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1--100]\u00E7Pedro Alberto"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[10-2-]\u00E7Pedro Alberto"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[]\u00E7Pedro Alberto"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E71-10-100\u00E7Pedro Alberto"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E7\u00E7[1-10-100,2-30-2.50,3-40-3.10]\u00E7Pedro"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7\u00E7Pedro"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1-10-100,2-30-2.50,3-40-3.10]"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1-10-100,2-30-2.50,3-40-3.10]\u00E7"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALE.id() + "\u00E701\u00E7[1-10-100,2-30-2.50,3-40-3.10]\u00E7Pedro\u00E7too much info"));
		
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.CLIENT.id() + "\u00E701\u00E7[1-10-100,2-30-2.50,3-40-3.10]\u00E7Pedro"));
		assertFalse(SalesRegistry.validateInputLine(RegistersIds.SALESMAN.id() + "\u00E701\u00E7[1-10-100,2-30-2.50,3-40-3.10]\u00E7Pedro"));

	}
	
}
