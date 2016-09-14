package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class LoginScreen {

	private JFrame f_frmStockseerLogin;
	private JTextField f_textFieldPassword;
	private JTextField f_textFieldUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.f_frmStockseerLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		f_frmStockseerLogin = new JFrame();
		f_frmStockseerLogin.setTitle("ExSim");
		f_frmStockseerLogin.setBounds(100, 100, 450, 300);
		f_frmStockseerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f_textFieldUsername = new JTextField();
		f_textFieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		
		f_textFieldPassword = new JTextField();
		f_textFieldPassword.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		JButton btnLogin = new JButton("Login");
		
		JButton btnResetPassword = new JButton("Reset Password");
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		GroupLayout groupLayout = new GroupLayout(f_frmStockseerLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(f_textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(f_textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCreateNewAccount)
							.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
							.addComponent(btnResetPassword))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(189)
							.addComponent(btnLogin)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(76, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(f_textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(f_textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin)
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateNewAccount)
						.addComponent(btnResetPassword))
					.addContainerGap())
		);
		f_frmStockseerLogin.getContentPane().setLayout(groupLayout);
	}
}
