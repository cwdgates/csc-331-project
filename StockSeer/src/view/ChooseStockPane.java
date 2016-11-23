package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import javax.swing.JScrollPane;

import view.model.AvailableStockModel;
import javax.swing.JTable;

public class ChooseStockPane extends JPanel {
	AvailableStockModel availStockModel;
	DefaultListModel addedStockModel;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ChooseStockPane() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnReroll = new JButton("Reroll");
		panel.add(btnReroll);
		
		JButton btnAccept = new JButton("Accept");
		panel.add(btnAccept);
		availStockModel = new AvailableStockModel();
		String[] demoAvailUesr = { "An", "John" };
		for (String temp : demoAvailUesr) {
			availStockModel.addElement(temp);
		}

		addedStockModel = new DefaultListModel();

	}

}
