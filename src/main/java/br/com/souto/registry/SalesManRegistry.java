package br.com.souto.registry;

import br.com.souto.repository.RegistersIds;

public class SalesManRegistry extends Registry {
	
	public SalesManRegistry(String cpf, String name, String sales) {
		this.id = RegistersIds.SALESMAN;
		this.cpf = cpf;
		this.name = name;
		this.sales = sales;
	}
	
	private String cpf;
	private String name;
	private String sales;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "SalesManRegistry [cpf=" + cpf + ", name=" + name + ", sales=" + sales + "]";
	}

}
