package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class SinglePlayer {

	private JFrame frmSingleplayer;
	private JTextField f_textFieldSearch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglePlayer window = new SinglePlayer();
					window.frmSingleplayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SinglePlayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSingleplayer = new JFrame();
		frmSingleplayer.setTitle("ExSim");
		frmSingleplayer.setBounds(100, 100, 800, 600);
		frmSingleplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmSingleplayer.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addComponent(btnMainMenu))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMainMenu)
					.addContainerGap())
		);

		JPanel panel_Portfolio = new JPanel();
		tabbedPane.addTab("Portfolio", null, panel_Portfolio, null);

		
		GroupLayout gl_panel_Portfolio = new GroupLayout(panel_Portfolio);
		gl_panel_Portfolio.setHorizontalGroup(gl_panel_Portfolio.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE));
		gl_panel_Portfolio.setVerticalGroup(gl_panel_Portfolio.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE));
		panel_Portfolio.setLayout(gl_panel_Portfolio);

		JPanel panel_Transaction = new JPanel();
		tabbedPane.addTab("Transaction", null, panel_Transaction, null);

		JPanel panel_FindStock = new JPanel();
		tabbedPane.addTab("Find Stock", null, panel_FindStock, null);

		JLabel lblName = new JLabel("Name");

		f_textFieldSearch = new JTextField();
		f_textFieldSearch.setColumns(10);

		JButton btnFind = new JButton("Find");
		GroupLayout gl_panel_FindStock = new GroupLayout(panel_FindStock);
		gl_panel_FindStock.setHorizontalGroup(
			gl_panel_FindStock.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_FindStock.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(f_textFieldSearch, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFind)
					.addContainerGap(529, Short.MAX_VALUE))
		);
		gl_panel_FindStock.setVerticalGroup(
			gl_panel_FindStock.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_FindStock.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_FindStock.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(f_textFieldSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFind))
					.addContainerGap(451, Short.MAX_VALUE))
		);
		panel_FindStock.setLayout(gl_panel_FindStock);

		JPanel panel_MyAccount = new JPanel();
		tabbedPane.addTab("My Account", null, panel_MyAccount, null);
		frmSingleplayer.getContentPane().setLayout(groupLayout);
	}
}
