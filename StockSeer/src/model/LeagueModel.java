package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import persistence.DBConnection;

public class LeagueModel {
	public static boolean isLeagueUnique(String leagueName) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id FROM league WHERE name = ?";
			statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, leagueName);
			rs = statement.executeQuery();
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public enum Difficulty {
		EASY, MEDIUM, HARD, NUT
	}

	private String leagueName;
	private String leagueID;
	private int maxPlayers;
	private Date startDate;
	private Date endDate;
	private Difficulty difficulty;

	private ArrayList<StockModel> stockList;

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(String leagueID) {
		this.leagueID = leagueID;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
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

	public static LeagueModel createLeague(String name, int maxPlayer, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		LeagueModel leagueModel = null;

		return leagueModel;
	}
}
