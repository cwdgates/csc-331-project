package backend;

public class StockWrapper {
	private int volume;
	private double price;
	private String initial;
	private String fullname;
	
	
	////////////////////////////////////////////////////////////
	// Getter  - Setter
	////////////////////////////////////////////////////////////
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	/////////////////////////////////////////////////////////
	// Constructor
	/////////////////////////////////////////////////////////
	public StockWrapper(){
		volume = -1;
		price = -1;
		initial = "NULL";
		fullname = "Null";
		System.out.println("Empty Stock Wrapper created");
	}
	
	
}
