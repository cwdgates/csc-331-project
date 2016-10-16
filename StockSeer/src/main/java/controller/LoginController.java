package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LoginModel;
import view.LoginPane;

/**
 * know about actions performed
 * 
 * @author aqv
 *
 */
public class LoginController implements ActionListener {
	private LoginPane loginPane;
	private LoginModel loginModel;

	public LoginController(LoginPane loginPane, LoginModel loginModel) {
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