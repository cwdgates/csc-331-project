package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistence.CredentialDao;
import ui.AppView;
import ui.LoginPane;

/**
 * know about actions performed
 * 
 * @author aqv
 *
 */
public class LoginController implements ActionListener {
	private LoginPane loginPane;
	private final String LOGIN_BTN = "Login";
	private final String SIGNUP_BTN = "Sign Up";
	private AppView appView;

	public LoginController(AppView appView) {
		this.loginPane = appView.getLoginPane();
		this.appView = appView;
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
			final String username = loginPane.getUsername().trim();
			final String password = loginPane.getPassword().trim();
			if (username.length() >= 4 && password.length() >= 4) {
				// check credential
				boolean isValid = CredentialDao.checkUsernamePassword(username, password);
				if (isValid) {
					System.out.println("Valid credential. Grant access to app.");
					loginPane.clear();
					appView.viewHome();

				} else {
					loginPane.showWrongPassword();
				}
			} else {
				loginPane.showPleaseFillUsernamePassword();
			}
		}
		if (command.equals(SIGNUP_BTN)) {
			System.out.println("Signup btn clicked");
		}

	}

}
