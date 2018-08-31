package br.com.souto.processor;

import java.util.List;

import br.com.souto.registry.Registry;

public class SalesManRegistersProcessor extends RegistersProcessor{
	
	public SalesManRegistersProcessor(List<Registry> registersList) {
		super(registersList);
	}

	public String process() {
		return "Number of Salesman: " + registersList.size();
	}

}
