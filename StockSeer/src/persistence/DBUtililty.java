package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Difficulty;

public abstract class DBUtililty {
	public static abstract class User {

	}

	public abstract static class League {
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

		public static boolean createLeague(String name, int capacity, GregorianCalendar startDate,
				GregorianCalendar endDate, Difficulty difficulty) {
			PreparedStatement insertStatement = null;
			try {
				String sql = "INSERT INTO league " + " (name, start_date, end_date, capacity, difficulty) "
						+ " VALUES (?,?,?,?,?)";
				insertStatement = DBConnection.getConnection().prepareStatement(sql);
				insertStatement.setString(1, name);
				insertStatement.setString(2, dateToString(startDate));
				insertStatement.setString(3, dateToString(endDate));
				insertStatement.setInt(4, capacity);
				insertStatement.setString(5, difficulty.toString());
				int numAffectedRow = insertStatement.executeUpdate();
				if (numAffectedRow == 0) {
					System.err.println("Can't insert a league to the database");
					return false;
				} else {
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

		private static String dateToString(GregorianCalendar date) {
			int day = date.get(Calendar.DATE);
			int month = date.get(Calendar.MONTH);
			int year = date.get(Calendar.YEAR);
			String dd = (day + "").length() == 2 ? (day + "") : ("0" + day);
			String mm = (month + "").length() == 2 ? (month + "") : ("0" + month);
			return year + "-" + mm + "-" + dd;
		}
	}
}
