package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import controller.LoginController;
import util.CredentialUtil;

import javax.swing.JButton;

public class LoginPane extends JPanel {
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JPanel panel;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JButton btnResetPassword;

	private CredentialUtil loginModel;

	/**
	 * Create the panel.
	 */
	public LoginPane(CredentialUtil loginModel) {
		this.loginModel = loginModel;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 17, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 0;
		add(lblUsername, gbc_lblUsername);

		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 0;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 1;
		add(lblPassword, gbc_lblPassword);

		txtPassword = new JTextField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 1;
		add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);

		btnLogin = new JButton("Login");
		panel.add(btnLogin);

		btnSignUp = new JButton("Sign Up");
		panel.add(btnSignUp);

		btnResetPassword = new JButton("Reset Password");
		panel.add(btnResetPassword);

	}

	public void registerListeners(LoginController loginController) {
		btnLogin.addActionListener(loginController);
		btnSignUp.addActionListener(loginController);
	}

	public void updateLoginModel() {
		// loginModel.setUsername(txtUsername.getText());
		// loginModel.setPassword(txtPassword.getText());
	}

	public String getUserName() {
		return txtUsername.getText();
	}

	public String getPassword() {
		return txtPassword.getText();
	}

}