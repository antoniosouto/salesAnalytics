package br.com.souto.registry;

import java.util.List;

import br.com.souto.repository.RegistersIds;

public class SalesManRegistry extends Registry {

	private String cpf;
	private String name;
	private String sales;
	
	public SalesManRegistry(String cpf, String name, String sales) {
		this.id = RegistersIds.SALESMAN;
		this.cpf = cpf;
		this.name = name;
		this.sales = sales;
	}
	
	public SalesManRegistry(String line) {
		if (!validateInputLine(line)) {
			throw  new IllegalArgumentException("Invalid input line: " + line);
		} else {
			String [] tokens = line.split("\u00E7");
			this.id = RegistersIds.SALESMAN;
			this.cpf = tokens[1];
			this.name = tokens[2];
			this.sales = tokens[3];
		}
	}
	
	public static boolean validateInputLine(final String line) {
		return line.matches(RegistersIds.SALESMAN.id() + "\u00E7[0-9]{13}\u00E7[a-zA-z ]+\u00E7[0-9]+(\\.[0-9][0-9])?");
	}
	
	public String process(List<Registry> registersList) {
		return "Number of Salesman: " + registersList.size();
	}

	@Override
	public String toString() {
		return "SalesManRegistry [cpf=" + cpf + ", name=" + name + ", sales=" + sales + "]";
	}

}
