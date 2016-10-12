package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginPane extends JPanel {
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Create the panel.
	 */
	public LoginPane() {
		setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblUsername = new JLabel("Username");
		add(lblUsername, "cell 0 0,alignx trailing");
		
		txtUsername = new JTextField();
		add(txtUsername, "cell 1 0,growx");
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		add(lblPassword, "cell 0 1,alignx trailing");
		
		txtPassword = new JTextField();
		add(txtPassword, "cell 1 1,growx");
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		add(btnLogin, "flowx,cell 1 2");
		
		JButton btnSignUp = new JButton("Sign Up");
		add(btnSignUp, "cell 1 2");
		
		JButton btnResetPassword = new JButton("Reset Password");
		add(btnResetPassword, "cell 1 2");

	}

}
