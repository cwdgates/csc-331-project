package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import persistence.RegistrationUtil;
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
				if (isFieldsEmpty()) {
					JOptionPane.showMessageDialog(appView, "There is at least one empty field.", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else if (!isPasswordsMatched()) {
					JOptionPane.showMessageDialog(appView, "The passwords you entered did not match.", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (!RegistrationUtil.isUsernameUnique(regPane.getUsername())) {
						JOptionPane.showMessageDialog(appView, "This username has been used by another account", "",
								JOptionPane.WARNING_MESSAGE);
					} else if (!RegistrationUtil.isEmailUnique(regPane.getEmail())) {
						JOptionPane.showMessageDialog(appView, "This email has been used by another account.", "",
								JOptionPane.WARNING_MESSAGE);
					}  else if (regPane.getPassword().length() < 6) {
						JOptionPane.showMessageDialog(appView, "Password need to have lastleast 6 characters", "",
								JOptionPane.WARNING_MESSAGE);
					} else {
						// register

						// clear text fields
						regPane.setTextFieldsEmpty();
					}
				}
				break;
			// ----------- END SIGN UP---------
			case RegistrationPane.CANCEL:
				appView.viewLogin();
				regPane.setTextFieldsEmpty();
				break;
			// ----------- END CANCEL----------
			default:
				break;
		}
		// clear all text fields in registration pane

	}

	/**
	 * check if any field is empty
	 * 
	 * @return false if at least one field is empty. True otherwise
	 */
	private boolean isFieldsEmpty() {
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
	private boolean isPasswordsMatched() {
		if (regPane.getPassword().compareTo(regPane.getRetypedPassword()) == 0) {
			return true;
		}
		return false;
	}

}
