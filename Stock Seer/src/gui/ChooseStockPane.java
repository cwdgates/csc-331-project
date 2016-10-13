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

public class ChooseStockPane extends JPanel {
	DefaultListModel availableUsers;
	DefaultListModel addedUsers;

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

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		JList listLeft = new JList();
		scrollPane.setViewportView(listLeft);
		availableUsers = new DefaultListModel();
		String[] demoAvailUesr = { "An", "John" };
		for (String temp : demoAvailUesr) {
			availableUsers.addElement(temp);
		}
		listLeft.setModel(availableUsers);

		Component horizontalGlue = Box.createHorizontalGlue();
		scrollPane.setColumnHeaderView(horizontalGlue);

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

		JButton btnNewButton = new JButton(">>");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnNewButton_1);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 0;
		add(scrollPane_1, gbc_scrollPane_1);

		JList listRight = new JList();
		listRight.setSize(listLeft.getSize());
		scrollPane_1.setViewportView(listRight);

		addedUsers = new DefaultListModel();

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		scrollPane_1.setColumnHeaderView(horizontalGlue_1);

	}

}
