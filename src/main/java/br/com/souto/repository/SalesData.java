package br.com.souto.repository;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.souto.container.ClientRegistersContainer;
import br.com.souto.container.RegistersContainer;
import br.com.souto.container.SalesManRegistersContainer;
import br.com.souto.container.SalesRegistersContainer;
import br.com.souto.registry.ClientRegistry;
import br.com.souto.registry.ItemSale;
import br.com.souto.registry.Registry;
import br.com.souto.registry.SalesManRegistry;
import br.com.souto.registry.SalesRegistry;

public class SalesData {
	
		public List<RegistersContainer> getRegistersContainers(List<String> registerLinesList) {
			
			List<RegistersContainer> registersContainersList = new ArrayList<RegistersContainer>();
			
			for (List<Registry> registersList: getRegisters(registerLinesList).values()) {
				registersContainersList.add(createRegistersContainers(registersList));
			}
			
			return registersContainersList;
			
		}
		
		private static RegistersContainer createRegistersContainers(List<Registry> registersList) {
			switch(registersList.get(0).getId()) {
			case SALESMAN:
				return new SalesManRegistersContainer(registersList);
			case CLIENT:
				return new ClientRegistersContainer(registersList);
			case ITEMSALE:
				return new SalesRegistersContainer(registersList);
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
			final String ccedilla = Character.toString('\u00E7');
			String [] tokens = line.split(ccedilla);
			if (tokens[0].equals(RegistersIds.SALESMAN.id())) {
				return new SalesManRegistry(tokens[1], tokens[2], tokens[3]);
			} else if (tokens[0].equals(RegistersIds.CLIENT.id())) {
				return new ClientRegistry(tokens[1], tokens[2], tokens[3]);
			} else if (tokens[0].equals(RegistersIds.ITEMSALE.id())) {
				return createSalesRegistry(tokens[1], tokens[2], tokens[3]);
			} else {
				throw new IllegalArgumentException("Invalid Id on line: " + line);
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

