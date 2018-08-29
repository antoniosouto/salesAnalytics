package br.com.souto.model;

import java.util.List;

public class SalesRegistry extends Registry{
	
	public SalesRegistry(String saleId, List<ItemSale> itemsList, String salesManName) {
		this.id = "103";
		this.saleId = saleId;
		this.ItemsList = itemsList;
		this.salesManName = salesManName;
	}
	
	private String saleId;
	private List<ItemSale> ItemsList;
	private String salesManName;
	
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public List<ItemSale> getItemsList() {
		return ItemsList;
	}
	public void setItemsList(List<ItemSale> itemsList) {
		ItemsList = itemsList;
	}
	public String getSalesManName() {
		return salesManName;
	}
	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}

}
