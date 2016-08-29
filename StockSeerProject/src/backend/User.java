package backend;
import java.util.Set;

import backend.StockWrapper;

public class User {
	private String userFullname;
	private String username;
	private String userPassword;
	
	private double account_balance;
	private Set<StockWrapper> stockWrappers; // store all stocks that the user own
	public String getUserFullname() {
		return userFullname;
	}
	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	public Set<StockWrapper> getStockWrappers() {
		return stockWrappers;
	}
	public void setStockWrappers(Set<StockWrapper> stockWrappers) {
		this.stockWrappers = stockWrappers;
	}
	
	
}
