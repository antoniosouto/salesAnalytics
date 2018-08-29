package br.com.souto.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.souto.model.ClientRegistry;
import br.com.souto.model.ItemSale;
import br.com.souto.model.Registry;
import br.com.souto.model.SalesManRegistry;
import br.com.souto.model.SalesRegistry;

public class SalesData {

		private Stream<String> stream;
		private List<String> list = new ArrayList<>();

		public void get() throws IOException {
			String fileName = "c://lines.txt";
	
			stream = Files.lines(Paths.get(fileName));
			stream.forEach(System.out::println);
		}
		
		public static Registry createRegistry(String line) {
			String [] tokens = line.split("ç");
			switch (tokens[0]) {
			case "001":
				return new SalesManRegistry(tokens[1], tokens[2], tokens[3]);
			case "002":
				return new ClientRegistry(tokens[1], tokens[2], tokens[3]);
			case "003":
				List <ItemSale> itemSales = new ArrayList<ItemSale>();
				String [] items = tokens[1].split(",");
				for (String item: items) {
					String [] itemFields = item.split("-");
					itemSales.add(new ItemSale(itemFields[0],
							Integer.getInteger(itemFields[1]),
							Double.valueOf(itemFields[2])));
				}
				return new SalesRegistry(tokens[0], itemSales, tokens[2]);
			default: return null;
			}
		}

}

