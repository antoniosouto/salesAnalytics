package br.com.souto.container;

import java.util.List;

import br.com.souto.registry.Registry;

public class ClientRegistersContainer extends RegistersContainer{
	
	public ClientRegistersContainer(List<Registry> registersList) {
		super(registersList);
	}

	public String process() {
		return "Number of Clients: " + registersList.size();
	}

}
