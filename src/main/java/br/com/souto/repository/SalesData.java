package br.com.souto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.souto.registry.ClientRegistry;
import br.com.souto.registry.Registry;
import br.com.souto.registry.SalesManRegistry;
import br.com.souto.registry.SalesRegistry;

public class SalesData {
	
		static public Map<RegistersIds, List<Registry>> getRegisters(List<String> registerLinesList) {
			
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
			try {
				return new SalesManRegistry(line);
			} catch (IllegalArgumentException e) {
				try {
					return new ClientRegistry(line);
				} catch (IllegalArgumentException e2) {
						return SalesRegistry.createSalesRegistry(line);
				}
			}
		}
}

