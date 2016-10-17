package model;

public class CredentialModel {
	private String username;
	private String password;

	public CredentialModel() {
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
