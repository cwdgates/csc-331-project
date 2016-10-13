package gui;

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
		panelForm.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblLeagueName = new JLabel("League Name");
		panelForm.add(lblLeagueName, "2, 2, right, default");

		textField = new JTextField();
		panelForm.add(textField, "4, 2, fill, default");
		textField.setColumns(10);

		JLabel lblNumberOfPlayers = new JLabel("Number of Players");
		panelForm.add(lblNumberOfPlayers, "2, 4, right, default");

		JComboBox comboBoxNumPlayers = new JComboBox();
		for (int i = 2; i <= 10; i++) {
			comboBoxNumPlayers.addItem(i);
		}
		panelForm.add(comboBoxNumPlayers, "4, 4, fill, default");

		JLabel lblStartDate = new JLabel("Start Date");
		panelForm.add(lblStartDate, "2, 6, right, default");

		// date format
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

		DatePickerPane startDatePicker = new DatePickerPane();
		panelForm.add(startDatePicker, "4, 6, fill, fill");

		JLabel lblEndDate = new JLabel("End Date");
		panelForm.add(lblEndDate, "2, 8, right, default");

		DatePickerPane endDatePicker = new DatePickerPane();
		panelForm.add(endDatePicker, "4, 8, fill, default");

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
