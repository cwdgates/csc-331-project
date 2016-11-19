package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.JScrollPane;

import model.AvailableStockModel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

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
