package br.com.souto.container;

import java.util.List;

import br.com.souto.registry.Registry;

public class SalesManRegistersContainer extends RegistersContainer{
	
	public SalesManRegistersContainer(List<Registry> registersList) {
		super(registersList);
	}

	public String process() {
		return "Number of Salesman: " + registersList.size();
	}

}
