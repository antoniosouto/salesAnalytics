package br.com.souto.processor;

import java.util.List;

import br.com.souto.registry.Registry;

public class ClientRegistersProcessor extends RegistersProcessor{
	
	public ClientRegistersProcessor(List<Registry> registersList) {
		super(registersList);
	}

	public String process() {
		return "Number of Clients: " + registersList.size();
	}

}
