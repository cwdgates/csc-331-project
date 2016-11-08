package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountModel;

/**
 * talk to database
 * 
 * @author anvu
 *
 */
public abstract class AccountUtility {

	/**
	 * get an account from the database using username and password
	 * 
	 * @param username
	 * @param password
	 * @return AccountModel
	 */
	public static AccountModel getAccountFromDB(String username, String password) {
		String query = "SELECT username, first_name, last_name FROM user WHERE username = ? AND password = ?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new AccountModel(resultSet.getString("username"), resultSet.getString("first_name"),
						resultSet.getString("last_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public static boolean isUsernameUnique(String username) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT id FROM user WHERE username = ?";
			statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
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
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmailUnique(String email) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT id FROM user WHERE email = ?";
			statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean registerAccount(String firstName, String lastName, String email, String username,
			String password) {
		PreparedStatement statement = null;
		int result = 0;
		try {
			String sql = "INSERT INTO user (first_name, last_name, email, username, password) VALUES (?,?,?,?,?)";
			statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);
			statement.setString(4, username);
			statement.setString(5, password);
			result = statement.executeUpdate();
			return result == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param username
	 * @param leagueName
	 * @return
	 */
	public static boolean joinLeague(String username, String leagueName) {
		PreparedStatement statement = null;
		int result = 0;
		try {
			String sql = "INSERT INTO user_league (username, league_name) VALUES (?,?)";
			statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, leagueName);
			result = statement.executeUpdate();
			return result == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
