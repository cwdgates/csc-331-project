package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;

import controller.RegistrationController;

public class RegistrationPane extends JPanel {
	public static final String SIGN_UP = "Sign Up";
	public static final String CANCEL = "Cancel";

	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField pwdPassword;
	private JPasswordField pwdRetypedpassword;
	private StringBuilder errorMessage;
	private JButton btnSignUp;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public RegistrationPane() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 105, 130, 0 };
		gridBagLayout.rowHeights = new int[] { 26, 26, 26, 26, 26, 26, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 0;
		add(lblFirstName, gbc_lblFirstName);

		txtFirstname = new JTextField();
		GridBagConstraints gbc_txtFirstname = new GridBagConstraints();
		gbc_txtFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstname.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstname.gridx = 2;
		gbc_txtFirstname.gridy = 0;
		add(txtFirstname, gbc_txtFirstname);
		txtFirstname.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 1;
		add(lblLastName, gbc_lblLastName);

		txtLastname = new JTextField();
		GridBagConstraints gbc_txtLastname = new GridBagConstraints();
		gbc_txtLastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastname.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastname.gridx = 2;
		gbc_txtLastname.gridy = 1;
		add(txtLastname, gbc_txtLastname);
		txtLastname.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 2;
		add(lblUsername, gbc_lblUsername);

		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 2;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 3;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);

		pwdPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 4;
		add(pwdPassword, gbc_pwdPassword);

		JLabel lblRetypedpassword = new JLabel("Retype Password");
		GridBagConstraints gbc_lblRetypedpassword = new GridBagConstraints();
		gbc_lblRetypedpassword.anchor = GridBagConstraints.EAST;
		gbc_lblRetypedpassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblRetypedpassword.gridx = 1;
		gbc_lblRetypedpassword.gridy = 5;
		add(lblRetypedpassword, gbc_lblRetypedpassword);

		pwdRetypedpassword = new JPasswordField();
		GridBagConstraints gbc_pwdRetypedpassword = new GridBagConstraints();
		gbc_pwdRetypedpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdRetypedpassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdRetypedpassword.gridx = 2;
		gbc_pwdRetypedpassword.gridy = 5;
		add(pwdRetypedpassword, gbc_pwdRetypedpassword);

		JPanel panelControl = new JPanel();
		GridBagConstraints gbc_panelControl = new GridBagConstraints();
		gbc_panelControl.anchor = GridBagConstraints.NORTH;
		gbc_panelControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelControl.gridx = 2;
		gbc_panelControl.gridy = 6;
		add(panelControl, gbc_panelControl);

		btnSignUp = new JButton(SIGN_UP);
		panelControl.add(btnSignUp);

		btnCancel = new JButton(CANCEL);
		panelControl.add(btnCancel);

	}

	/**
	 * check field
	 * 
	 * @return true if at least one field is empty. False if all field are
	 *         correctly filled
	 */
	boolean isFieldEmpty() {
		if (txtEmail.getText().trim().length() == 0 || txtFirstname.getText().trim().length() == 0
				|| txtLastname.getText().trim().length() == 0 || txtUsername.getText().trim().length() == 0
				|| String.valueOf(pwdPassword.getPassword()).trim().length() == 0) {
			return false;
		}
		return true;
	}

	public void registerListeners(RegistrationController controller) {
		btnCancel.addActionListener(controller);
		btnSignUp.addActionListener(controller);
	}

	/**
	 * check if at least one text field is empty
	 * 
	 * @return
	 */
	public boolean areFieldsEmpty() {
		for (Component component : this.getComponents()) {
			if (component instanceof JTextField) {
				if (((JTextField) component).getText().compareTo("") == 0) {
					System.out.println("Empty field");
					return false;
				}
			}
		}
		return true;
	}

	public StringBuilder getErrorMessage() {
		return errorMessage;
	}

	public String getFirstName() {
		return txtFirstname.getText();
	}

	public String getLastName() {
		return txtLastname.getText();

	}

	public String getUsername() {
		return txtUsername.getText();
	}

	public String getEmail() {
		return txtEmail.getText();
	}

	public String getPassword() {
		return new String(pwdPassword.getPassword());
	}
	
	public String getRetypedPassword(){
		return new String(pwdRetypedpassword.getPassword());
	}

}
