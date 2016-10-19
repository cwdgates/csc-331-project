package ui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class CreateLeaguePane extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CreateLeaguePane() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 194, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panelForm = new JPanel();
		GridBagConstraints gbc_panelForm = new GridBagConstraints();
		gbc_panelForm.anchor = GridBagConstraints.NORTH;
		gbc_panelForm.insets = new Insets(0, 0, 5, 0);
		gbc_panelForm.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelForm.gridx = 0;
		gbc_panelForm.gridy = 0;
		add(panelForm, gbc_panelForm);
		GridBagLayout gbl_panelForm = new GridBagLayout();
		gbl_panelForm.columnWidths = new int[]{115, 327, 0};
		gbl_panelForm.rowHeights = new int[]{26, 27, 27, 27, 0};
		gbl_panelForm.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelForm.setLayout(gbl_panelForm);
						
								JLabel lblLeagueName = new JLabel("League Name");
								GridBagConstraints gbc_lblLeagueName = new GridBagConstraints();
								gbc_lblLeagueName.anchor = GridBagConstraints.EAST;
								gbc_lblLeagueName.insets = new Insets(0, 0, 5, 5);
								gbc_lblLeagueName.gridx = 0;
								gbc_lblLeagueName.gridy = 0;
								panelForm.add(lblLeagueName, gbc_lblLeagueName);
				
						textField = new JTextField();
						GridBagConstraints gbc_textField = new GridBagConstraints();
						gbc_textField.anchor = GridBagConstraints.NORTH;
						gbc_textField.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField.insets = new Insets(0, 0, 5, 0);
						gbc_textField.gridx = 1;
						gbc_textField.gridy = 0;
						panelForm.add(textField, gbc_textField);
						textField.setColumns(10);
		
				JLabel lblNumberOfPlayers = new JLabel("Number of Players");
				GridBagConstraints gbc_lblNumberOfPlayers = new GridBagConstraints();
				gbc_lblNumberOfPlayers.anchor = GridBagConstraints.EAST;
				gbc_lblNumberOfPlayers.insets = new Insets(0, 0, 5, 5);
				gbc_lblNumberOfPlayers.gridx = 0;
				gbc_lblNumberOfPlayers.gridy = 1;
				panelForm.add(lblNumberOfPlayers, gbc_lblNumberOfPlayers);
		
				JComboBox comboBoxNumPlayers = new JComboBox();
				GridBagConstraints gbc_comboBoxNumPlayers = new GridBagConstraints();
				gbc_comboBoxNumPlayers.anchor = GridBagConstraints.NORTH;
				gbc_comboBoxNumPlayers.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxNumPlayers.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxNumPlayers.gridx = 1;
				gbc_comboBoxNumPlayers.gridy = 1;
				panelForm.add(comboBoxNumPlayers, gbc_comboBoxNumPlayers);
		
				JLabel lblStartDate = new JLabel("Start Date");
				GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
				gbc_lblStartDate.anchor = GridBagConstraints.EAST;
				gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
				gbc_lblStartDate.gridx = 0;
				gbc_lblStartDate.gridy = 2;
				panelForm.add(lblStartDate, gbc_lblStartDate);
				
						DatePickerPane startDatePicker = new DatePickerPane();
						GridBagConstraints gbc_startDatePicker = new GridBagConstraints();
						gbc_startDatePicker.fill = GridBagConstraints.BOTH;
						gbc_startDatePicker.insets = new Insets(0, 0, 5, 0);
						gbc_startDatePicker.gridx = 1;
						gbc_startDatePicker.gridy = 2;
						panelForm.add(startDatePicker, gbc_startDatePicker);
		
				JLabel lblEndDate = new JLabel("End Date");
				GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
				gbc_lblEndDate.anchor = GridBagConstraints.EAST;
				gbc_lblEndDate.insets = new Insets(0, 0, 0, 5);
				gbc_lblEndDate.gridx = 0;
				gbc_lblEndDate.gridy = 3;
				panelForm.add(lblEndDate, gbc_lblEndDate);
		
				DatePickerPane endDatePicker = new DatePickerPane();
				GridBagConstraints gbc_endDatePicker = new GridBagConstraints();
				gbc_endDatePicker.anchor = GridBagConstraints.NORTH;
				gbc_endDatePicker.fill = GridBagConstraints.HORIZONTAL;
				gbc_endDatePicker.gridx = 1;
				gbc_endDatePicker.gridy = 3;
				panelForm.add(endDatePicker, gbc_endDatePicker);
		for (int i = 2; i <= 10; i++) {
			comboBoxNumPlayers.addItem(i);
		}

		// date format
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

		JButton btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 0;
		gbc_btnCreate.gridy = 1;
		add(btnCreate, gbc_btnCreate);

	}

	/**
	 * create a format that restrict JFormattedTextField accepts only 2 numbers
	 * 
	 * @param s
	 * @return
	 */
	private static MaskFormatter createFormatter(String s) {
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter(s);
		} catch (ParseException e) {
			System.err.println("Formatter is bad: " + e.getMessage());
		}
		return mf;
	}

}
