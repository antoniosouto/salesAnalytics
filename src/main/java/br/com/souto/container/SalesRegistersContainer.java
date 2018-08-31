package br.com.souto.container;

import java.util.List;

import br.com.souto.registry.Registry;

public class SalesRegistersContainer extends RegistersContainer{
	
	public SalesRegistersContainer(List<Registry> registersList) {
		super(registersList);
	}

	public String process() {
		return "SalesRegisters";
	}

}
