package br.com.souto.registry;

import java.util.List;

import br.com.souto.repository.RegistersIds;

public class SalesRegistry extends Registry{
	
	public SalesRegistry(String saleId, List<ItemSale> itemsList, String salesManName) {
		this.id = RegistersIds.ITEMSALE;
		this.saleId = saleId;
		this.itemsList = itemsList;
		this.salesManName = salesManName;
	}
	
	private String saleId;
	private List<ItemSale> itemsList;
	private String salesManName;
	private double sellValueSum;
	
	public double getSellValuesSum() {
		this.sellValueSum = 0.0;
		itemsList.forEach((item) -> sellValueSum += item.getSaleValue());
		return this.sellValueSum;
	}
	
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public List<ItemSale> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemSale> itemsList) {
		this.itemsList = itemsList;
	}
	public String getSalesManName() {
		return salesManName;
	}
	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}
	@Override
	public String toString() {
		return "SalesRegistry [saleId=" + saleId + ", itemsList=" + itemsList + ", salesManName=" + salesManName + "]";
	}

}
