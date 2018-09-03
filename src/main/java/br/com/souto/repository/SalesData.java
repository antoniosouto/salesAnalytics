package br.com.souto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.souto.processor.ClientRegistersProcessor;
import br.com.souto.processor.RegistersProcessor;
import br.com.souto.processor.SalesManRegistersProcessor;
import br.com.souto.processor.SalesRegistersProcessor;
import br.com.souto.registry.ClientRegistry;
import br.com.souto.registry.ItemSale;
import br.com.souto.registry.Registry;
import br.com.souto.registry.SalesManRegistry;
import br.com.souto.registry.SalesRegistry;

public class SalesData {
	
		public List<RegistersProcessor> getRegistersProcessors(List<String> registerLinesList) {
			
			List<RegistersProcessor> registersProcessorsList = new ArrayList<RegistersProcessor>();
			
			for (List<Registry> registersList: getRegisters(registerLinesList).values()) {
				registersProcessorsList.add(createRegistersProcessors(registersList));
			}
			
			return registersProcessorsList;
			
		}
		
		private static RegistersProcessor createRegistersProcessors(List<Registry> registersList) {
			switch(registersList.get(0).getId()) {
			case SALESMAN:
				return new SalesManRegistersProcessor(registersList);
			case CLIENT:
				return new ClientRegistersProcessor(registersList);
			case ITEMSALE:
				return new SalesRegistersProcessor(registersList);
			default:
				throw new IllegalStateException("Invalid State.");
					
			}
		}

		private Map<RegistersIds, List<Registry>> getRegisters(List<String> registerLinesList) {
			
			Map<RegistersIds, List<Registry>> registers= new HashMap<RegistersIds, List<Registry>>();
			for (RegistersIds type: RegistersIds.values()) {
				registers.put(type, new ArrayList<Registry>());
			}
			
			for (String registerLine: registerLinesList) {
				Registry registry = createRegistry(registerLine);
				registers.get(registry.getId()).add(registry);
			}
			
			return registers;
		}
		
		private static Registry createRegistry(String line) {
			// Latin Small Letter c with cedilla
			try {
				return new SalesManRegistry(line);
			} catch (IllegalArgumentException e) {
				try {
					return new ClientRegistry(line);
				} catch (IllegalArgumentException e2) {
						return createSalesRegistry(line);
				}
			}
		}
		
		private static SalesRegistry createSalesRegistry(String line) {
			if (!SalesRegistry.validateInputLine(line)) {
				throw  new IllegalArgumentException("Invalid input line: " + line);
			} else {
				String [] tokens = line.split("\u00E7");
				return createSalesRegistry(tokens[1], tokens[2], tokens[3]);
			}
		}
		
		private static SalesRegistry createSalesRegistry(String saleId,
				String itemsList,String salesManName) {
			
			List <ItemSale> itemSales = new ArrayList<ItemSale>();
			String [] items = itemsList.substring(1, itemsList.length()-1).split(",");
			
			for (String item: items) {
				String [] itemFields = item.split("-");
				itemSales.add(new ItemSale(itemFields[0],
						Integer.parseInt(itemFields[1]),
						Double.valueOf(itemFields[2])));
			}
			
			return new SalesRegistry(saleId, itemSales, salesManName);
		}

}

