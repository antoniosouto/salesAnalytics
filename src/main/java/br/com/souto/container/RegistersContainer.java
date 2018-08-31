package br.com.souto.container;

import java.util.List;

import br.com.souto.registry.Registry;

public abstract class RegistersContainer {
	
	public <T> RegistersContainer(List<Registry> registersList) {
		this.registersList = registersList;
	}

	List<Registry> registersList;
	
	public abstract String process();

	@Override
	public String toString() {
		return "RegistersContainer [registersList=" + registersList + "]";
	}
	

}
