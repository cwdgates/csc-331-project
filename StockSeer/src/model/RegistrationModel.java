package model;

import java.sql.Connection;

import persistence.DBConnection;

/**
 * talk to database
 * 
 * @author anvu
 *
 */
public class RegistrationModel {

	private static Connection connection = DBConnection.getConnection();
	private String username, password, email, firstname, lastname;

	/**
	 * construstor
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param email
	 */
	public RegistrationModel(String firstname, String lastname, String username, String password, String email) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}

	/**
	 * validate registration data
	 * 
	 * @return true if registration data meets requirement, false otherwise
	 */
	public boolean validate() {

		return false;
	}

	/**
	 * insert user data to user table in the database
	 * 
	 * @return
	 */
	public static boolean registerUser() {
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
