package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.RegistrationModel;
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
			if (!regPane.areFieldsEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty fields", "Error", JOptionPane.WARNING_MESSAGE);
			} // mismatch password
			else if (regPane.getPassword().compareTo(regPane.getRetypedPassword()) != 0) {
				JOptionPane.showMessageDialog(null, "Mismatched password", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				RegistrationModel regModel = new RegistrationModel(regPane.getFirstName(), regPane.getLastName(),
						regPane.getEmail(), regPane.getUsername(), regPane.getPassword());
				boolean isSuccess = regModel.register();
				JOptionPane.showMessageDialog(null, regModel.getStatusMessage(), "Registration Status",
						JOptionPane.INFORMATION_MESSAGE);
				if (isSuccess) {
					appView.viewLogin();
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
