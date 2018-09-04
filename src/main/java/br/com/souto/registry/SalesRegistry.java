package br.com.souto.registry;

import java.util.ArrayList;
import java.util.List;

import br.com.souto.repository.RegistersIds;

public class SalesRegistry extends Registry{
	
	private String saleId;
	private List<ItemSale> itemsList;
	private String salesManName;
	private double sellValueSum;
	
	public SalesRegistry(String saleId, List<ItemSale> itemsList, String salesManName) {
		this.id = RegistersIds.SALE;
		this.saleId = saleId;
		this.itemsList = itemsList;
		this.salesManName = salesManName;
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

	public double getSellValuesSum() {
		this.sellValueSum = 0.0;
		itemsList.forEach((item) -> sellValueSum += item.getSaleValue());
		return this.sellValueSum;
	}
	
	public String process(List<Registry> registersList) {
		return "Highest value sell ID: " +  getHighestValueSellId(registersList) + "\n" 
				+ "Worst SalesMan: " + getWorstSalesManName(registersList);
	}
	
	private String getHighestValueSellId(List<Registry> registersList) {
		String highestValueSellId = "";
		double highestValueSellValue = 0.0;
		for (Registry salesRegistry : registersList) {
			for (ItemSale itemSale :  ((SalesRegistry) salesRegistry).getItemsList()) {
				if (itemSale.getSaleValue() > highestValueSellValue) {
					highestValueSellId = itemSale.getId();
					highestValueSellValue = itemSale.getSaleValue();
				}
			}
		}
		return highestValueSellId;
	}
	
	private String getWorstSalesManName(List<Registry> registersList) {
		String worstSalesManName = new String();
		double lowestValueSellValue = 10000000000.0;
		for (Registry salesRegistry : registersList) {
			if (((SalesRegistry) salesRegistry).getSellValuesSum() < lowestValueSellValue) {
				worstSalesManName = ((SalesRegistry) salesRegistry).getSalesManName();
			}
		}
		return worstSalesManName;
	}
	
	public List<ItemSale> getItemsList() {
		return itemsList;
	}

	public String getSalesManName() {
		return salesManName;
	}

	@Override
	public String toString() {
		return "SalesRegistry [saleId=" + saleId + ", itemsList=" + itemsList + ", salesManName=" + salesManName + "]";
	}

	public static boolean validateInputLine(String line) {
		return line.matches(RegistersIds.SALE.id() + "\u00E7[0-9]+\u00E7\\["
				+ "([0-9]+-[0-9]+-[0-9]+(\\.[0-9][0-9])?,)*"
				+ "([0-9]+-[0-9]+-[0-9]+(\\.[0-9][0-9])?)"
				+ "\\]\u00E7[a-zA-z ]+");
	}

}
