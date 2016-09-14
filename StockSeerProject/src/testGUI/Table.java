package testGUI;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;

public class Table {

	private JFrame frame;
	
	Vector f_model = new Vector();
	Vector f_row = new Vector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
		provideData();
	}

	private void provideData() {
		// TODO Auto-generated method stub
		f_row.add("an vu");
		f_row.add("demarcus");
		
		f_model.add(f_row);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
