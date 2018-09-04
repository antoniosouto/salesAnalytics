package br.com.souto.analytics;

import java.util.Collection;
import java.util.List;

import br.com.souto.registry.Registry;

public class SalesAnalysis {
	
	String reports = new String();
	
	public String process( Collection<List<Registry>>  registryListsMap) {
		for (List<Registry> registersList : registryListsMap) {
			if (registersList != null && registersList.size() > 0) {
				/* Strategy Design Pattern
				 * The process is defined in the subclass
				 */
				reports += registersList.get(0).process(registersList) + "\n";
			}
		}
		return reports;
	}

}
