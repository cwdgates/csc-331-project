package controller;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUpPane extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public SignUpPane() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblFirstName = new JLabel("First Name");
		add(lblFirstName, "2, 2, right, default");
		
		textField = new JTextField();
		add(textField, "4, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		add(lblLastName, "2, 4, right, default");
		
		textField_1 = new JTextField();
		add(textField_1, "4, 4, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "2, 6, right, default");
		
		textField_2 = new JTextField();
		add(textField_2, "4, 6, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		add(lblPassword, "2, 8, right, default");
		
		textField_3 = new JTextField();
		add(textField_3, "4, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		add(lblRetypePassword, "2, 10, right, default");
		
		textField_4 = new JTextField();
		add(textField_4, "4, 10, fill, default");
		textField_4.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		add(btnRegister, "4, 12");

	}

}
