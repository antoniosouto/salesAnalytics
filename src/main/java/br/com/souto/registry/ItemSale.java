package br.com.souto.registry;

public class ItemSale {
	
	private String id;
	private Integer quantity;
	private Double price;
	
	public ItemSale(String id, Integer quantity, Double price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public double getSaleValue() {
		return this.quantity * this.price;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ItemSale [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
