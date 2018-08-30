package br.com.souto.model;

import br.com.souto.repository.RegistersIds;

public class ClientRegistry extends Registry {
	
	public ClientRegistry(String cnpj, String name, String businessArea) {
		this.id = RegistersIds.CLIENT;
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}
	
	private String cnpj;
	private String name;
	private String businessArea;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	@Override
	public String toString() {
		return "ClientRegistry [cnpj=" + cnpj + ", name=" + name + ", businessArea=" + businessArea + "]";
	}

}
