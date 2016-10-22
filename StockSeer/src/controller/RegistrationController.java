package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.RegistrationModel;
import model.RegistrationModel.RegistrationError;
import ui.AppView;
import ui.RegistrationPane;

public class RegistrationController implements ActionListener {
	AppView appView;
	RegistrationPane regPane;

	public RegistrationController(AppView appView) {
		this.appView = appView;
		regPane = appView.getSignUpPane();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		switch (command) {
		case RegistrationPane.SIGN_UP: {
			if (!regPane.validateTextFields()) {
				break;
			}
			RegistrationModel regModel = new RegistrationModel(regPane.getFirstName(), regPane.getLastName(),
					regPane.getEmail(), regPane.getUsername(), regPane.getPassword());

			RegistrationError error = regModel.register();
			if (error != null) {
				StringBuilder errMsg = new StringBuilder();
				if (error.dup_email) {
					errMsg.append("This email has been registered by another account.");
				}
				if (error.dup_username) {
					errMsg.append("\nThis username has been registered by another account.");
				}
				if (errMsg.toString() != "") {
					JOptionPane.showMessageDialog(null, errMsg.toString(), "Registration unsuccesssfuls",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			break;
		} // end SIGNUP
		case RegistrationPane.CANCEL: {
			appView.viewLogin();
			break;
		}

		default:
			break;
		}
	}

}
