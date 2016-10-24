package ui;

import javax.swing.JPanel;

import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class DatePickerPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public DatePickerPane() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JLabel lblMonth = new JLabel("Month");
		add(lblMonth);

		JComboBox<String> cbMonth = new JComboBox<String>();
		add(cbMonth);
		cbMonth.addItem("--");
		for (int i = 1; i <= 12; i++) {
			cbMonth.addItem(i + "");
		}

		JLabel lblDay = new JLabel("Day");
		add(lblDay);

		JComboBox<String> cbDay = new JComboBox<String>();
		add(cbDay);
		cbDay.addItem("--");
		for (int i = 1; i <= 31; i++) {
			cbDay.addItem(i + "");
		}

		JLabel lblYear = new JLabel("Year");
		add(lblYear);

		JComboBox<String> cbYear = new JComboBox<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		cbYear.addItem("--");
		for (int i = year; i <= year + 2; i++) {
			cbYear.addItem(i + "");
		}
		add(cbYear);
	}
}
