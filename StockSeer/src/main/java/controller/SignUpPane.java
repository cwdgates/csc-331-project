package controller;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;

public class SignUpPane extends JPanel {
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField pwdPassword;
	private JPasswordField pwdRetypedpassword;

	/**
	 * Create the panel.
	 */
	public SignUpPane() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 0;
		add(lblFirstName, gbc_lblFirstName);

		txtFirstname = new JTextField();
		GridBagConstraints gbc_txtFirstname = new GridBagConstraints();
		gbc_txtFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstname.gridx = 1;
		gbc_txtFirstname.gridy = 0;
		add(txtFirstname, gbc_txtFirstname);
		txtFirstname.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 1;
		add(lblLastName, gbc_lblLastName);

		txtLastname = new JTextField();
		GridBagConstraints gbc_txtLastname = new GridBagConstraints();
		gbc_txtLastname.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastname.gridx = 1;
		gbc_txtLastname.gridy = 1;
		add(txtLastname, gbc_txtLastname);
		txtLastname.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 2;
		add(lblUsername, gbc_lblUsername);

		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 2;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 3;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);

		pwdPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.gridx = 1;
		gbc_pwdPassword.gridy = 4;
		add(pwdPassword, gbc_pwdPassword);

		JLabel lblRetypedpassword = new JLabel("Retype Password");
		GridBagConstraints gbc_lblRetypedpassword = new GridBagConstraints();
		gbc_lblRetypedpassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblRetypedpassword.anchor = GridBagConstraints.EAST;
		gbc_lblRetypedpassword.gridx = 0;
		gbc_lblRetypedpassword.gridy = 5;
		add(lblRetypedpassword, gbc_lblRetypedpassword);

		pwdRetypedpassword = new JPasswordField();
		GridBagConstraints gbc_pwdRetypedpassword = new GridBagConstraints();
		gbc_pwdRetypedpassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdRetypedpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdRetypedpassword.gridx = 1;
		gbc_pwdRetypedpassword.gridy = 5;
		add(pwdRetypedpassword, gbc_pwdRetypedpassword);

		JButton btnSignUp = new JButton("Sign Up");
		GridBagConstraints gbc_btnSignUp = new GridBagConstraints();
		gbc_btnSignUp.insets = new Insets(0, 0, 0, 5);
		gbc_btnSignUp.gridx = 1;
		gbc_btnSignUp.gridy = 6;
		add(btnSignUp, gbc_btnSignUp);

	}
	
	public void registerListeners(){
		
	}

}
