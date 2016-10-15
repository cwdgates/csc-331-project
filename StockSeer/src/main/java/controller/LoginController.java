package controller;

import gui.LoginPane;
import model.CredentialModel;

public class LoginController {
	private LoginPane loginPane;
	private CredentialModel credentialModel;
	
	public LoginController(LoginPane l, CredentialModel c){
		loginPane = l;
		credentialModel = c;
	}
	
	
}
