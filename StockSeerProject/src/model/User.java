package model;

import java.util.Set;

import model.StockWrapper;

public class User {
	private String userFullname;
	private String username;
	private String userPassword;

	private double account_balance;
	private Set<StockWrapper> stockWrappers; // store all stocks that the user
												// own

	//////////////////////////////////////////////////////////////////////////
	// constructor
	//////////////////////////////////////////////////////////////////////////
	public User(){
	}
	
	public User(String userFullname, String username, String password){
		this.userFullname = userFullname;
		this.username = username;
		this.userPassword = password;
	}

	/////////////////////////////////////////////////////////////////////////
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

	public void addStockWrapper(StockWrapper stockWrapper) {
		this.stockWrappers.add(stockWrapper);
	}

	public void getStockWrapper(String stockInitial) {
	}

}
