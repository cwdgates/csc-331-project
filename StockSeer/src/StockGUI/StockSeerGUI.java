package StockGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Engine.StockInfo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockSeerGUI extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldStockName;
	private JButton btnCheck;
	private JTextField textFieldPrice;
	private JTextField textFieldStockFullname;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StockSeerGUI frame = new StockSeerGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public StockSeerGUI() {
		initComponents();
		createEvents();

	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStock = new JLabel("Stock:");
		
		textFieldStockName = new JTextField();
		textFieldStockName.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		
		textFieldPrice = new JTextField();
		textFieldPrice.setEditable(false);
		textFieldPrice.setColumns(10);
		
		btnCheck = new JButton("Check");
		
		JLabel lblName = new JLabel("Name");
		
		textFieldStockFullname = new JTextField();
		textFieldStockFullname.setColumns(10);


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(351, Short.MAX_VALUE)
					.addComponent(btnCheck)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStock)
						.addComponent(lblPrice))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldStockName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblName)
							.addGap(18)
							.addComponent(textFieldStockFullname, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
						.addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStock)
						.addComponent(textFieldStockName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)
						.addComponent(textFieldStockFullname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
					.addComponent(btnCheck)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// Contains code for creating events
	/////////////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		// TODO Auto-generated method stub
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CheckButton Clicked");
				StockInfo stockInfo = new StockInfo(textFieldStockName.getText());
				textFieldPrice.setText(stockInfo.getPrice() + "");
				textFieldStockFullname.setText(stockInfo.getStockName());
//				JOptionPane.showMessageDialog(null, "Fuck you");
			}
		});
		
	}
}
