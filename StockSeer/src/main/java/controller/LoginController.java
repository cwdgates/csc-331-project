package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.CredentialUtil;
import view.LoginPane;

/**
 * know about actions performed
 * 
 * @author aqv
 *
 */
public class LoginController implements ActionListener {
	private LoginPane loginPane;
	private CredentialUtil loginModel;

	public LoginController(LoginPane loginPane, CredentialUtil loginModel) {
		this.loginPane = loginPane;
		this.loginModel = loginModel;
	}

	/**
	 * check for button click in login panel
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Login")) {
			System.out.println("Login");
			loginPane.updateLoginModel();
		}
	}

}
