package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import persistence.DBConnection;

public class UserModel {
	private String firstName;
	private String lastName;
	private int id;

	public UserModel() {
	}

	public UserModel(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getUserId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserID(int id) {
		this.id = id;
	}

	public boolean fetchUserInfo(String username, String password) {
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("id");
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
				System.out.println("id: " + id + " first name " + firstName);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
