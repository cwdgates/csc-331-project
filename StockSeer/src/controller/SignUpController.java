package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;
import ui.SignUpPane;

public class SignUpController implements ActionListener {
	AppView appView;
	SignUpPane signUpPane;

	public SignUpController(AppView appView) {
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
