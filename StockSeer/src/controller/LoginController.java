package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import model.CredentialModel;
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
			performLogin();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void performLogin() {
		// loginPane.updateLoginModel();
		final String username = loginPane.getUsername().trim();
		final String password = loginPane.getPassword().trim();
		if (username.length() > 0 && password.length() > 0) {
			// check credential
			boolean isValid = CredentialModel.checkUsernamePassword(username, password);
			if (isValid) {
				loginPane.clear();
				appView.viewHome();
				JOptionPane.showMessageDialog(appView, "Access granted");
			} else {
				JOptionPane.showMessageDialog(loginPane, "Wrong username or password");
			}
		} else {
			JOptionPane.showMessageDialog(loginPane, "Please fill in username and password");
		}
	}

}
