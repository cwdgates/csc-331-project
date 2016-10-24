package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import persistence.DBConnection;

/**
 * talk to database
 * 
 * @author anvu
 *
 */
public class RegistrationModel {
	public class RegistrationStatus {
		public boolean dup_email, dup_username;

		public RegistrationStatus() {
			dup_email = false;
			dup_email = false;
		}
	}

	private static Connection connection = DBConnection.getConnection();
	private String username, password, email, firstname, lastname;

	/**
	 * constructor
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param email
	 */
	public RegistrationModel(String firstname, String lastname, String email, String username, String password) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}

	public RegistrationStatus register() {
		RegistrationStatus status = new RegistrationStatus();
		try {
			ResultSet resultSet;
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT  iduser FROM user WHERE username = ?");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				status.dup_username = true;
			}
			preparedStatement = connection.prepareStatement("SELECT  iduser FROM user WHERE email = ?");
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				status.dup_email = true;
			}
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// insert data
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO user (firstname,lastname, email ,username, password) VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, password);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
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
