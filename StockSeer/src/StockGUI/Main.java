package StockGUI;
import java.awt.EventQueue;

import StockGUI.*;

public class Main {

	public static void main(String[] args) {
		// Run the GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockSeerGUI frame = new StockSeerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
