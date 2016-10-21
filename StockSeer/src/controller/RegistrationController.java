package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;
import ui.SignUpPane;

public class RegistrationController implements ActionListener {
	AppView appView;
	SignUpPane signUpPane;

	public RegistrationController(AppView appView) {
		this.appView = appView;
		signUpPane = appView.getSignUpPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case SignUpPane.SIGN_UP: {
			//
			break;
		}
		case SignUpPane.CANCEL: {
			appView.viewLogin();
			break;
		}

		default:
			break;
		}
	}

}
