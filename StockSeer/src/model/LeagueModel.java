package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import persistence.Date;

public class LeagueModel {
	private String leagueName;
	private Integer leagueID;
	private int capacity;
	private Date startDate;
	private Date endDate;
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

	public LeagueModel(Integer id, String name, int capacity, Date startDate, Date endDate, Difficulty difficulty) {
		this.leagueID = id;
		this.leagueName = name;
		this.capacity = 0;
		this.startDate = startDate;
		this.endDate = endDate;
		this.difficulty = difficulty;
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

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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
	 * @return id name start_date end_date difficulty
	 */
	@Override
	public String toString() {
		return "ID=" + leagueID + " NAME=" + leagueName + " START=" + startDate.toString() + " END="
				+ endDate.toString() + " DIFFICULTY=" + difficulty.name();
	}
}
