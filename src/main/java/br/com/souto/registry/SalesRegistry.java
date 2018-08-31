package br.com.souto.registry;

import java.util.List;

import br.com.souto.repository.RegistersIds;

public class SalesRegistry extends Registry{
	
	public SalesRegistry(String saleId, List<ItemSale> itemsList, String salesManName) {
		this.id = RegistersIds.ITEMSALE;
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
	@Override
	public String toString() {
		return "SalesRegistry [saleId=" + saleId + ", ItemsList=" + ItemsList + ", salesManName=" + salesManName + "]";
	}

}
