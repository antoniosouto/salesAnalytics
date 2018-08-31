package br.com.souto.processor;

import java.util.List;

import br.com.souto.registry.ItemSale;
import br.com.souto.registry.Registry;
import br.com.souto.registry.SalesRegistry;

public class SalesRegistersProcessor extends RegistersProcessor{
	
	public SalesRegistersProcessor(List<Registry> registersList) {
		super(registersList);
	}

	public String process() {
		return "Highest value sell ID: " +  getHighestValueSellId() + "\n" 
				+ "Worst SalesMan: " + getWorstSalesManName();
	}
	
	private String getHighestValueSellId() {
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
	
	private String getWorstSalesManName() {
		String worstSalesManName = new String();
		double lowestValueSellValue = 10000000000.0;
		for (Registry salesRegistry : registersList) {
			if (((SalesRegistry) salesRegistry).getSellValuesSum() < lowestValueSellValue) {
				worstSalesManName = ((SalesRegistry) salesRegistry).getSalesManName();
			}
		}
		return worstSalesManName;
	}

}
