package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.DefaultListModel;

import javax.swing.JScrollPane;

import view.renderModel.AvailableStockModel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

public class ChooseStockPane extends JPanel {
	AvailableStockModel availStockModel;
	DefaultListModel addedStockModel;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ChooseStockPane() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnReroll = new JButton("Reroll");
		panel.add(btnReroll);
		
		JButton btnAccept = new JButton("Accept");
		panel.add(btnAccept);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, BorderLayout.NORTH);
		
		JTextPane txtpnClickRerollTo = new JTextPane();
		txtpnClickRerollTo.setText("Click reroll to choose different stocks");
		txtpnClickRerollTo.setToolTipText("");
		scrollPane_1.setViewportView(txtpnClickRerollTo);

	}

}
