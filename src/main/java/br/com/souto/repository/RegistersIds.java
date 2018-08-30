package br.com.souto.repository;

public enum RegistersIds {
	SALESMAN ("001"),
	CLIENT ("002"),
	ITEMSALE ("003");
	
	private final String registerId;
	
	RegistersIds(String registerId) {
		this.registerId = registerId;
	}
	
	public final String id( ) {
		return this.registerId;
	}
}
