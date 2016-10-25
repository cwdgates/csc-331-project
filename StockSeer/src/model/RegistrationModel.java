package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.DBConnection;

/**
 * talk to database
 * 
 * @author anvu
 *
 */
public class RegistrationModel {
	private StringBuilder statusMessage;

	private static Connection connection = DBConnection.getConnection();
	private String username, password, email, firstname, lastname;

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param username
	 * @param password
	 */
	public RegistrationModel(String firstname, String lastname, String email, String username, String password) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}

	public String getStatusMessage() {
		return statusMessage.toString();
	}

	public boolean register() {
		statusMessage = new StringBuilder();
		PreparedStatement preparedStatement = null;
		// check for duplicated account
		try {
			ResultSet resultSet;
			preparedStatement = connection.prepareStatement("SELECT id FROM user WHERE username = ?");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				statusMessage.append("Username has been used by another account");
			}
			preparedStatement.close();
			resultSet.close();

			preparedStatement = connection.prepareStatement("SELECT id FROM user WHERE email = ?");
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				statusMessage.append("\nEmail has been used by another account");
			}
			preparedStatement.close();
			resultSet.close();

			if (statusMessage.toString().length() > 0) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// insert user
		try {
			String insertUserSQL = "INSERT INTO user" + "(first_name,last_name, email ,username, password) VALUES"
					+ "(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertUserSQL);
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, password);
			statusMessage = new StringBuilder("Successfully created an account");
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("rowCount" + rowCount);
			if (rowCount > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
