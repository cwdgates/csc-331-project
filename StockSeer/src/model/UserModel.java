package model;

public class UserModel {
	private String firstName;
	private String lastName;
	private String userID;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserId() {
		return userID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserID(String user_id) {
		this.userID = user_id;
	}
}
