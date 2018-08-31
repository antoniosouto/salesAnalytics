package br.com.souto.processor;

import java.util.List;

import br.com.souto.registry.Registry;

public abstract class RegistersProcessor {
	
	public <T> RegistersProcessor(List<Registry> registersList) {
		this.registersList = registersList;
	}

	List<Registry> registersList;
	
	public abstract String process();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [registersList=" + registersList + "]";
	}
	

}
