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
			case RegistrationPane.SIGN_UP:
				if (fieldsEmpty()) {
					JOptionPane.showMessageDialog(appView, "Empty fields", "Error", JOptionPane.WARNING_MESSAGE);
				} else if (misMatchedPassword()) {
					JOptionPane.showMessageDialog(null, "Mismatched password", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					RegistrationModel regModel = new RegistrationModel(regPane.getFirstName(), regPane.getLastName(),
							regPane.getEmail(), regPane.getUsername(), regPane.getPassword());
					boolean isSuccess = regModel.register();
					JOptionPane.showMessageDialog(appView, regModel.getStatusMessage(), "Registration Status",
							JOptionPane.INFORMATION_MESSAGE);
					if (isSuccess) {
						appView.viewLogin();
					}
				}
				break;
			// ----------- END SIGN UP---------
			case RegistrationPane.CANCEL:
				appView.viewLogin();
				break;
			// ----------- END CANCEL----------
			default:
				break;
		}
		// clear all text fields in registration pane
		regPane.clear();

	}

	/**
	 * check if any field is empty
	 * 
	 * @return false if at least one field is empty. True otherwise
	 */
	private boolean fieldsEmpty() {
		if (regPane.getUsername().length() == 0 || regPane.getFirstName().length() == 0
				|| regPane.getLastName().length() == 0 || regPane.getPassword().length() == 0
				|| regPane.getRetypedPassword().length() == 0 || regPane.getEmail().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * check if the password field and retyped password field are the same
	 * 
	 * @return
	 */
	private boolean misMatchedPassword() {
		if (regPane.getPassword().compareTo(regPane.getRetypedPassword()) == 0) {
			return false;
		}
		return true;
	}

}
