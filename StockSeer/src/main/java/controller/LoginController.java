package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.CredentialDao;
import view.LoginPane;

/**
 * know about actions performed
 * 
 * @author aqv
 *
 */
public class LoginController implements ActionListener {
	private LoginPane loginPane;
	private CredentialDao loginModel;
	private final String LOGIN_BTN = "Login";
	private final String SIGNUP_BTN = "Sign Up";

	public LoginController(LoginPane loginPane, CredentialDao loginModel) {
		this.loginPane = loginPane;
		this.loginModel = loginModel;
	}

	/**
	 * check for button click in login panel
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		// login button clicked
		if (command.equals(LOGIN_BTN)) {
			System.out.println("Login clicked");
			loginPane.updateLoginModel();
			if (loginPane.getUserName().trim().length() >= 6 && loginPane.getPassword().trim().length() >= 6) {

			} else {
				System.out.println("Please fill in username and password");
			}
		}
		if (command.equals(SIGNUP_BTN)) {
			System.out.println("Signup btn clicked");
		}

	}

}
