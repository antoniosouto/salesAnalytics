package br.com.souto.registry;

import java.util.ArrayList;
import java.util.List;

import br.com.souto.repository.RegistersIds;

public class SalesRegistry extends Registry{
	
	public SalesRegistry(String saleId, List<ItemSale> itemsList, String salesManName) {
		this.id = RegistersIds.ITEMSALE;
		this.saleId = saleId;
		this.itemsList = itemsList;
		this.salesManName = salesManName;
	}
	
	public double getSellValuesSum() {
		this.sellValueSum = 0.0;
		itemsList.forEach((item) -> sellValueSum += item.getSaleValue());
		return this.sellValueSum;
	}
	
	public static SalesRegistry createSalesRegistry(String line) {
		if (!SalesRegistry.validateInputLine(line)) {
			throw  new IllegalArgumentException("Invalid input line: " + line);
		} else {
			String [] tokens = line.split("\u00E7");
			return createSalesRegistry(tokens[1], tokens[2], tokens[3]);
		}
	}
	
	private static SalesRegistry createSalesRegistry(String saleId,
			String itemsList,String salesManName) {
		
		List <ItemSale> itemSales = new ArrayList<ItemSale>();
		String [] items = itemsList.substring(1, itemsList.length()-1).split(",");
		
		for (String item: items) {
			String [] itemFields = item.split("-");
			itemSales.add(new ItemSale(itemFields[0],
					Integer.parseInt(itemFields[1]),
					Double.valueOf(itemFields[2])));
		}
		
		return new SalesRegistry(saleId, itemSales, salesManName);
	}

	private String saleId;
	private List<ItemSale> itemsList;
	private String salesManName;
	private double sellValueSum;
	
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

	public static boolean validateInputLine(String line) {
		return line.matches(RegistersIds.ITEMSALE.id() + "\u00E7[0-9]+\u00E7\\["
				+ "([0-9]+-[0-9]+-[0-9]+(\\.[0-9][0-9])?,)*"
				+ "([0-9]+-[0-9]+-[0-9]+(\\.[0-9][0-9])?)"
				+ "\\]\u00E7[a-zA-z ]+");
	}

}
