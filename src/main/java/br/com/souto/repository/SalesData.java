package br.com.souto.repository;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.souto.analytics.ClientRegisters;
import br.com.souto.analytics.Registers;
import br.com.souto.analytics.SalesManRegisters;
import br.com.souto.analytics.SalesRegisters;
import br.com.souto.model.ClientRegistry;
import br.com.souto.model.ItemSale;
import br.com.souto.model.Registry;
import br.com.souto.model.SalesManRegistry;
import br.com.souto.model.SalesRegistry;

public class SalesData {
	
		public List<Registers> getRegistersContainers() throws IOException {
			
			List<Registers> registersContaiersList = new ArrayList<Registers>();
			
			for (List<Registry> value: getRegisters().values()) {
				
				
			}
			
		}

		public Map<RegistersIds, List<Registry>> getRegisters() throws IOException {
			String fileName = "lines.txt";
			List<String> registersList = new ArrayList<>();
			registersList = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).collect(Collectors.toList());
			
			Map<RegistersIds, List<Registry>> registers= new HashMap<RegistersIds, List<Registry>>();
			for (RegistersIds type: RegistersIds.values()) {
				registers.put(type, new ArrayList<Registry>());
			}
			
			for (String registerLine: registersList) {
				Registry registry = createRegistry(registerLine);
				registers.get(registry.getId()).add(registry);
			}
			
			System.out.println(registers);
			
			return registers;
		}
		
		private static Registry createRegistry(String line) {
			String [] tokens = line.split("�");
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
		
		private static SalesRegistry createSalesRegistry(String saleId, String itemsList, String salesManName) {
			
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
		
		private static Registers createRegistersContainers(List<Registry> registersList) {
			switch(registersList.get(0).getId()) {
			case SALESMAN:
				return new SalesManRegisters();
			case CLIENT:
				return new ClientRegisters();
			case ITEMSALE:
				return new SalesRegisters();
			default:
				throw new IllegalStateException("Invalid State.");
					
			}
		}

}

