package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import persistence.DBConnection;

public class UserModel {
	private String firstName = null;
	private String lastName = null;
	private Integer id = null;

	public UserModel() {
	}

	public UserModel(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() throws NullPointerException {
		if (id == null) {
			throw new NullPointerException("User object's fields are null");
		} else {
			return id;
		}
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * clear local data relates to user. Main purpose is for logging out
	 */
	public void setFieldsNull() {
		id = null;
		firstName = null;
		lastName = null;
	}

	@Override
	public String toString() {
		return "User: id=" + id + " firstname=" + firstName + " lastname=" + lastName;
	}

	public boolean getStatus() {
		// FIXME rough estimation
		if (id != null)
			return true;
		return false;
	}

}
