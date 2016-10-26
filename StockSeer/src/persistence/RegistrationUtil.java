package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;

/**
 * talk to database
 * 
 * @author anvu
 *
 */
public abstract class RegistrationUtil {
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

	public static boolean isEmailUnique(String email) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT id FROM user WHERE email = ?";
			statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return false;
			}
		} catch (Exception e) {
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

	public static UserModel register(String firstName, String lastName, String email, String username,
			String password) {
		UserModel user = null;
		PreparedStatement insertStatement = null;
		try {
			String insertQuery = "INSERT INTO user (first_name, last_name, email, username, password) VALUES"
					+ "(?,?,?,?,?)";
			insertStatement = DBConnection.getConnection().prepareStatement(insertQuery);
			insertStatement.setString(1, firstName);
			insertStatement.setString(2, lastName);
			insertStatement.setString(3, email);
			insertStatement.setString(4, username);
			insertStatement.setString(5, password);
			int numRowAffected = insertStatement.executeUpdate();

			// get id, first_name, last_name from database
			if (numRowAffected > 0) {
				PreparedStatement selectStatement = null;
				ResultSet rs = null;
				try {
					String selectQuery = "SELECT id, first_name, last_name FROM user WHERE username = ?";
					selectStatement = DBConnection.getConnection().prepareStatement(selectQuery);
					selectStatement.setString(1, username);
					rs = selectStatement.executeQuery();

					if (rs.next()) {
						int retId = rs.getInt("id");
						String retFirstName = rs.getString("first_name");
						String retLastName = rs.getString("last_name");
						user = new UserModel(retId, retFirstName, retLastName);
					}

				} catch (SQLException e) {
					System.err.println("Failed to SELECT");
					e.printStackTrace();
				} finally {
					try {
						selectStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("Failed to INSERT");
			e.printStackTrace();
		} finally {
			try {
				insertStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
