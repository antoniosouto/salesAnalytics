package br.com.souto.registry;

import java.util.List;

import br.com.souto.repository.RegistersIds;

public class Registry {
	
	protected RegistersIds id;

	public RegistersIds getId() {
		return id;
	}

	public void setId(RegistersIds id) {
		this.id = id;
	}

	public String process(List<Registry> registersList) {
		return "";
	}

}