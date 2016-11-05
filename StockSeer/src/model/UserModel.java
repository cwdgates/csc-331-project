package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import persistence.DBConnection;

public class UserModel {
	private String firstName = null;
	private String lastName = null;
	private Integer id = null;

	public UserModel() {
		this.id = null;
		this.firstName = null;
		this.lastName = null;
	}

	public UserModel(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Object factory
	 * 
	 * @param username
	 * @param password
	 * @return UserModel object if username and password match <br>
	 *         null if username and password not match
	 */
	public static UserModel getUserFromDB(String username, String password) {
		UserModel userModel = null;
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userModel = new UserModel();
				userModel.id = new Integer(resultSet.getInt("id"));
				userModel.firstName = resultSet.getString("first_name");
				userModel.lastName = resultSet.getString("last_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userModel;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() throws NullPointerException {
		return id;
	}

	/**
	 * clear local data relates to user. Main purpose is for logging out<br>
	 * This will set id, firstname, and lastname to null
	 */
	public void clearUser() {
		if (id != null)
			id = null;
		if (firstName != null)
			firstName = null;
		if (lastName != null)
			lastName = null;
	}

	/**
	 * @return a string in this format User: id= firstname= lastname=
	 */
	public String getInfo() {
		return "User: id=" + id + " firstname=" + firstName + " lastname=" + lastName;
	}

	public boolean getStatus() {
		// FIXME rough estimation
		if (id != null)
			return true;
		return false;
	}

}
