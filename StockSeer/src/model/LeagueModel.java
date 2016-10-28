package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import persistence.DBConnection;

public class LeagueModel {

	public enum Difficulty {
		EASY, MEDIUM, HARD, NUT;
	}

	private String leagueName;
	private Integer leagueID;
	private int capacity;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	private Difficulty difficulty;

	private ArrayList<StockModel> stockList;

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

	/**
	 * Object factory for LeagueModel
	 * 
	 * @param name
	 * @param capacity
	 * @param startDate
	 * @param endDate
	 * @param difficulty
	 * @return null if the function can't insert league into database
	 */
	public static LeagueModel createLeague(String name, int capacity, GregorianCalendar startDate,
			GregorianCalendar endDate, LeagueModel.Difficulty difficulty) {
		LeagueModel leagueModel = null;
		PreparedStatement insertStatement = null;
		try {
			// purpose: to insert league into database
			String sql = "INSERT INTO league " + " (name, start_date, end_data, capacity, difficulty) "
					+ " VALUES (?,?,?,?,?)";
			insertStatement = DBConnection.getConnection().prepareStatement(sql);
			insertStatement.setString(1, name);
			insertStatement.setString(2, dateToString(startDate));
			insertStatement.setString(3, dateToString(endDate));
			insertStatement.setInt(4, capacity);
			insertStatement.setInt(5, difficulty.ordinal());
			int numAffectedRow = insertStatement.executeUpdate();
			if (numAffectedRow > 0) {
				leagueModel = new LeagueModel();
				leagueModel.leagueName = name;
				leagueModel.capacity = capacity;
				leagueModel.startDate = startDate;
				leagueModel.endDate = endDate;
			} else {
				System.err.println("Can't insert a league to the database");
			}

			PreparedStatement selectStatement = null;
			ResultSet rs = null;
			try {
				// purpose: to get league ID
				String selectSQL = "SELECT id FROM league WHERE name = ?";
				selectStatement = DBConnection.getConnection().prepareStatement(selectSQL);
				selectStatement.setString(1, name);
				rs = selectStatement.executeQuery();
				if (rs.next()) {
					leagueModel.leagueID = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				selectStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				insertStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return leagueModel;
	}

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
	static private String dateToString(GregorianCalendar date) {
		int day = date.get(Calendar.DATE);
		int month = date.get(Calendar.MONTH);
		int year = date.get(Calendar.YEAR);
		String dd = (day + "").length() == 2 ? (day + "") : ("0" + day);
		String mm = (month + "").length() == 2 ? (month + "") : ("0" + month);
		return year + "-" + mm + "-" + dd;
	}
}
