package gui;

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

public class ChooseStockPane extends JPanel {
	AvailableStockModel availStockModel;
	DefaultListModel addedStockModel;

	/**
	 * Create the panel.
	 */
	public ChooseStockPane() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPaneAvailable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneAvailable = new GridBagConstraints();
		gbc_scrollPaneAvailable.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneAvailable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAvailable.gridx = 0;
		gbc_scrollPaneAvailable.gridy = 0;
		add(scrollPaneAvailable, gbc_scrollPaneAvailable);

		JList availableStocks = new JList();
		scrollPaneAvailable.setViewportView(availableStocks);
		availStockModel = new AvailableStockModel();
		String[] demoAvailUesr = { "An", "John" };
		for (String temp : demoAvailUesr) {
			availStockModel.addElement(temp);
		}
		availableStocks.setModel(availStockModel);

		Component horizontalGlue = Box.createHorizontalGlue();
		scrollPaneAvailable.setColumnHeaderView(horizontalGlue);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		Component verticalGlue = Box.createVerticalGlue();
		panel_1.add(verticalGlue);

		JButton btnAdd = new JButton(">>");
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnAdd);

		JButton btnRemove = new JButton("<<");
		btnRemove.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnRemove);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_1);

		JScrollPane scrollPaneAdded = new JScrollPane();
		GridBagConstraints gbc_scrollPaneAdded = new GridBagConstraints();
		gbc_scrollPaneAdded.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAdded.gridx = 2;
		gbc_scrollPaneAdded.gridy = 0;
		add(scrollPaneAdded, gbc_scrollPaneAdded);

		JList addedStocks = new JList();
		addedStocks.setSize(availableStocks.getSize());
		scrollPaneAdded.setViewportView(addedStocks);

		addedStockModel = new DefaultListModel();

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		scrollPaneAdded.setColumnHeaderView(horizontalGlue_1);

	}

}
