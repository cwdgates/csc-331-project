package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import model.CredentialChecker;
import model.UserModel;
import ui.AppView;
import ui.LoginPane;

/**
 * know about actions performed
 * 
 * @author aqv
 *
 */
public class LoginController implements ActionListener, KeyListener {
	private LoginPane loginPane;

	private AppView appView;
	private UserModel userModel;

	public LoginController(AppView appView) {
		this.loginPane = appView.getLoginPane();
		this.appView = appView;
	}

	public void registerUser(UserModel userModel) {
		this.userModel = userModel;
	}

	/**
	 * check for button click in login panel
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		switch (command) {
			case LoginPane.LOGIN_BTN: {
				performLogin();
				break;
			}
			case LoginPane.SIGNUP_BTN: {
				appView.viewSignUp();
				break;
			}

			default: {
				break;
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (loginPane.getUsername().length() > 0 && loginPane.getPassword().length() == 0) {
				JOptionPane.showMessageDialog(loginPane, "Please fill in username and password.");
			}
			performLogin();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void performLogin() {
		// check credential
		boolean isValid = CredentialChecker.checkUsernameAndPassword(loginPane.getUsername().trim(),
				loginPane.getPassword().trim());
		if (isValid) {
			// ------ GRANT ACCESS -------
			userModel = new UserModel();
			userModel.fetchUserInfo(loginPane.getUsername().trim(), loginPane.getPassword().trim());
			loginPane.clear();
			JOptionPane.showMessageDialog(appView, "Welcome " + userModel.getFirstName() + " " + userModel.getLastName() + ".\nClick OK to continue.");
		} else {
			JOptionPane.showMessageDialog(loginPane, "Wrong username or password.");
		}
	}
}
