package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;
import ui.RegistrationPane;

public class RegistrationController implements ActionListener {
	AppView appView;
	RegistrationPane registrationPane;

	public RegistrationController(AppView appView) {
		this.appView = appView;
		registrationPane = appView.getSignUpPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case RegistrationPane.SIGN_UP: {
			if (!registrationPane.validateTextFields()) {
				break;
			} else {
				
			}
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
