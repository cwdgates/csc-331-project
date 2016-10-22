package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;
import ui.RegistrationPane;

public class RegistrationController implements ActionListener {
	AppView appView;
	RegistrationPane signUpPane;

	public RegistrationController(AppView appView) {
		this.appView = appView;
		signUpPane = appView.getSignUpPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case RegistrationPane.SIGN_UP: {
			//
			break;
		}
		case RegistrationPane.CANCEL: {
			appView.viewLogin();
			break;
		}

		default:
			break;
		}
	}

}
