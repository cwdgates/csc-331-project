package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import persistence.DBConnection;

public class UserModel {
	private String firstName;
	private String lastName;
	private Integer id = null;

	public UserModel() {
		firstName = "";
		lastName = "";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	public void login(String username, String password) {
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = new Integer(resultSet.getInt("id"));
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
				System.out.println("id: " + id + " first name " + firstName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * clear local data relates to user. Main purpose is for logging out
	 */
	public void reset() {
		id = null;
		firstName = null;
		lastName = null;
	}

}
