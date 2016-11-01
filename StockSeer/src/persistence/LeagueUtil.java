package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Difficulty;
import model.League;

public abstract class LeagueUtil {

	public static boolean isLeagueNameUnique(String leagueName) {
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
			return false; // operation failed
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("Can't close statement");
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean createLeague(String name, int capacity, Date startDate, Date endDate, Difficulty difficulty) {
		PreparedStatement insertStatement = null;
		try {
			String sql = "INSERT INTO league " + " (name, start_date, end_date, capacity, difficulty) "
					+ " VALUES (?,?,?,?,?)";
			insertStatement = DBConnection.getConnection().prepareStatement(sql);
			insertStatement.setString(1, name);
			insertStatement.setString(2, startDate.toString());
			insertStatement.setString(3, endDate.toString());
			insertStatement.setInt(4, capacity);
			insertStatement.setString(5, difficulty.toString());
			int numAffectedRow = insertStatement.executeUpdate();
			if (numAffectedRow == 0) {
				System.err.println("Can't insert a league to the database");
				return false;
			} else {
				System.out.println(
						name + " " + startDate.toString() + " " + endDate.toString() + " " + difficulty.toString());
				return true;
			}
		} catch (SQLException e) {
			System.err.println("Can't insert.");
			e.printStackTrace();
		} finally {
			try {
				insertStatement.close();
			} catch (SQLException e) {
				System.err.println("Can't close statement.");
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * get league from the database
	 * 
	 * @param leagueName
	 * @return LeagueModel object
	 */
	public static League getLeague(String leagueName) {
		League league = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM league WHERE name = ?";
			statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, leagueName);
			rs = statement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int capacity = rs.getInt("capacity");
				Date startDate = new Date(rs.getString("start_date"));
				Date endDate = new Date(rs.getString("end_date"));
				Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
				league = new League(id, name, capacity, startDate, endDate, difficulty);
			}
		} catch (SQLException e) {
			System.err.println("Can't get league.");
			e.printStackTrace();
			return null;
		}
		return league;
	}

	/**
	 * 
	 * @return
	 */
	public static ArrayList<League> getAllLeagues() {
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<League> leagues = null;

		try {
			String sql = "SELECT * FROM league";
			statement = DBConnection.getConnection().prepareStatement(sql);
			rs = statement.executeQuery();
			leagues = new ArrayList<League>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int capacity = rs.getInt("capacity");
				Date startDate = new Date(rs.getString("start_date"));
				Date endDate = new Date(rs.getString("end_date"));
				Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
				League league = new League(id, name, capacity, startDate, endDate, difficulty);
				System.out.println(league.toString());
				leagues.add(league);
			}

		} catch (SQLException e) {
			System.err.println("Can't get all leagues from DB");
			e.printStackTrace();
			return null;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("Can't close statement.");
				e.printStackTrace();
			}
		}

		return leagues;
	}
}
