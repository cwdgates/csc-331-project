package testGUI;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TableTest {

	private JFrame f_frame;
	
	DefaultTableModel f_defTableModel;
	private JTable f_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableTest window = new TableTest();
					window.f_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void populateDataForStockTable(){
		Vector column_names = new Vector();
		column_names.add("Sticker");
		column_names.add("Price");
		column_names.add("Amount");

		
		Vector stockList = new Vector();
		Vector yahooStock = new Vector();
		
		// fill yahoostock info
		yahooStock.add("Yahoo INC");
		yahooStock.add(8.84f);
		
		// populate stockList
		stockList.add(yahooStock);
		
		f_defTableModel = new DefaultTableModel(stockList, column_names){
			
		};
	}

	/**
	 * Create the application.
	 */
	public TableTest() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		f_frame = new JFrame();
		f_frame.setBounds(100, 100, 450, 300);
		f_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		populateDataForStockTable();

		f_table = new JTable(f_defTableModel);
		GroupLayout groupLayout = new GroupLayout(f_frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(f_table, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(f_table, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		f_frame.getContentPane().setLayout(groupLayout);
	}

}
