package br.com.souto.model;

public class ItemSale {
	
	public ItemSale(String id, Integer quantity, Double price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	
	private String id;
	private Integer quantity;
	private Double price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ItemSale [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
