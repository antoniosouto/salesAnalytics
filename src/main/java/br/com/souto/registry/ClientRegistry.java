package br.com.souto.registry;

import java.util.List;

import br.com.souto.repository.RegistersIds;

public class ClientRegistry extends Registry {

	private String cnpj;
	private String name;
	private String businessArea;

	public ClientRegistry(String cnpj, String name, String businessArea) {
		this.id = RegistersIds.CLIENT;
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}
	
	public ClientRegistry(String line) {
		if (!validateInputLine(line)) {
			throw  new IllegalArgumentException("Invalid input line: " + line);
		} else {
			String [] tokens = line.split("\u00E7");
			this.id = RegistersIds.CLIENT;
			this.cnpj = tokens[1];
			this.name = tokens[2];
			this.businessArea = tokens[3];
		}
	}
	
	public static boolean validateInputLine(String line) {
		return line.matches(RegistersIds.CLIENT.id() + "\u00E7[0-9]{16}\u00E7[a-zA-z ]+\u00E7[a-zA-z ]+");
	}
	
	public String process(List<Registry> registersList) {
		return "Number of Clients: " + registersList.size();
	}
	
	@Override
	public String toString() {
		return "ClientRegistry [cnpj=" + cnpj + ", name=" + name + ", businessArea=" + businessArea + "]";
	}
	
}
