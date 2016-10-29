package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import persistence.DBConnection;

public class LeagueModel {
	private String leagueName;
	private Integer leagueID;
	private int capacity;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	private Difficulty difficulty;

	private ArrayList<StockModel> stockList;

	public LeagueModel() {
		leagueID = null;
		leagueName = null;
		capacity = 0;
		startDate = null;
		endDate = null;
		difficulty = null;
		stockList = null;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public Integer getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(Integer leagueID) {
		this.leagueID = leagueID;
	}

	public int getMaxPlayers() {
		return capacity;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.capacity = maxPlayers;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public ArrayList<StockModel> getStockList() {
		return stockList;
	}

	public void setStockList(ArrayList<StockModel> stockList) {
		this.stockList = stockList;
	}

	public void addStock(StockModel stock) {
		this.stockList.add(stock);
	}

	/**
	 * Return the string representation of GregorianCalendar date as
	 * <b>YYYY-MM-DD</b> format. Main purpose is for database
	 * 
	 * @param date
	 * @return date in <b>YYYY-MM-DD</b> format. Example 2015-04-23
	 */
}
