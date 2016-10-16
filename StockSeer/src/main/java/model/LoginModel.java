package model;

public class LoginModel {
	private String username;
	private String password;

	public LoginModel() {
		username = "";
		password = "";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
