package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import persistence.CredentialChecker;
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

	public LoginController(AppView appView, UserModel userModel) {
		this.loginPane = appView.getLoginPane();
		this.appView = appView;
		this.userModel = userModel;
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
			case LoginPane.LOGIN_BTN:
				if (validateFields()) {
					performLogin();
				}
				break;
			case LoginPane.SIGNUP_BTN:
				appView.viewSignUp();
				break;

			default:
				break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// if press enter key
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (validateFields()) {
				performLogin();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void performLogin() {
		// check credential
		boolean isValid = CredentialChecker.checkUsernameAndPassword(loginPane.getUsername(),
				loginPane.getPassword().trim());
		if (isValid) {
			/*
			 * Grant access to the application. The object stay alive until
			 * logout.
			 */
			userModel = new UserModel();
			userModel = UserModel.getUser(loginPane.getUsername(), loginPane.getPassword());

			// show welcome pane
			String msg = "Welcome " + userModel.getFirstName() + " " + userModel.getLastName()
					+ ".\nClick OK to continue.";
			JOptionPane.showMessageDialog(appView, msg, "", JOptionPane.INFORMATION_MESSAGE);
			appView.viewHome(); // change the scene to Home
			loginPane.setTextFieldsEmpty(); // clear text field
		} else {
			JOptionPane.showMessageDialog(loginPane, "Wrong username or password.", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Check whether the username and password fields are empty
	 * 
	 * @return <b>True</b> if username and password are not empty.<br>
	 *         <b>False</b> otherwise.
	 */
	private boolean validateFields() {
		if (loginPane.getUsername().length() == 0 || loginPane.getPassword().length() == 0) {
			JOptionPane.showMessageDialog(loginPane, "Please fill in username and password.", "",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
