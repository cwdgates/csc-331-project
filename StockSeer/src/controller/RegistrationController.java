package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import persistence.AccountUtility;
import view.AppView;
import view.RegistrationPane;

import org.apache.commons.validator.routines.EmailValidator;

public class RegistrationController implements ActionListener {
	private AppView appView;
	private RegistrationPane regPane;

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
			} else if (!isPasswordsMatched(regPane.getPassword(), regPane.getRetypedPassword())) {
				JOptionPane.showMessageDialog(appView, "The passwords you entered did not match.", "",
						JOptionPane.WARNING_MESSAGE);
			} else if (!isPasswordValid(regPane.getPassword()) || !isPasswordValid(regPane.getRetypedPassword())) {
				JOptionPane.showMessageDialog(appView,
						"The password you entered is not valid.\nPassword cannot have space(s).", "",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (!AccountUtility.isUsernameUnique(regPane.getUsername())) {
					JOptionPane.showMessageDialog(appView, "This username has been used by another account", "",
							JOptionPane.WARNING_MESSAGE);
				} else if (!EmailValidator.getInstance().isValid(regPane.getEmail())) {
					JOptionPane.showMessageDialog(appView, "Invalid email.", "", JOptionPane.WARNING_MESSAGE);
				} else if (!AccountUtility.isEmailUnique(regPane.getEmail())) {
					JOptionPane.showMessageDialog(appView, "This email has been used by another account.", "",
							JOptionPane.WARNING_MESSAGE);
				} else if (regPane.getPassword().length() < 6) {
					JOptionPane.showMessageDialog(appView, "Password need to have lastleast 6 characters", "",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// register
					String firstName = regPane.getFirstName();
					String lastName = regPane.getLastName();
					String email = regPane.getEmail();
					String username = regPane.getUsername();
					String password = regPane.getPassword();
					boolean result = AccountUtility.registerAccount(firstName, lastName, email, username, password);
					if (result) {
						JOptionPane.showMessageDialog(appView, "Successfully created an account.", "",
								JOptionPane.INFORMATION_MESSAGE);
						appView.viewLogin();
					} else {
						JOptionPane.showMessageDialog(appView, "Cannot create this account.\nPlease try again.", "",
								JOptionPane.WARNING_MESSAGE);
					}
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
		// ----------- END BTN_CANCEL----------
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
		return regPane.getUsername().length() == 0 || regPane.getFirstName().length() == 0
				|| regPane.getLastName().length() == 0 || regPane.getPassword().length() == 0
				|| regPane.getRetypedPassword().length() == 0 || regPane.getEmail().length() == 0;
	}

	/**
	 * check if the password field and retyped password field are the same
	 * 
	 * @return
	 */
	private boolean isPasswordsMatched(String password, String retypedPassword) {
		if (password.compareTo(retypedPassword) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * determine if the password is in valid form. That mean no space
	 * 
	 * @param password
	 * @return
	 */
	private boolean isPasswordValid(String password) {
		return password.indexOf(' ') == -1;
	}

}
