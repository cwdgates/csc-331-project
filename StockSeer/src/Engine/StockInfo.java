package Engine;

import java.io.IOException;
import java.math.BigDecimal;

import org.omg.PortableServer.ServantActivator;

import yahoofinance.*;

public class StockInfo {
	private Stock stock;
	private String name;
	
	public StockInfo(String name){
		try {
			stock = YahooFinance.get(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getStockName() {
		return stock.getName();
	}

	public Double getPrice(){
		BigDecimal price = stock.getQuote().getPrice();
		return price.doubleValue();
	}
	
	public int getVolume(){
		return stock.getQuote().getVolume().intValue();
	}
	
	public static void main(String[] args){
		StockInfo yahoo = new StockInfo("YHOO");
		System.out.println(yahoo.getPrice());
		System.out.println(yahoo.getVolume());
	}
}
