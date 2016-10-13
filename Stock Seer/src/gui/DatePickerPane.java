package gui;

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

		JLabel lblDay = new JLabel("Day");
		add(lblDay);

		JComboBox cbDay = new JComboBox();
		for (int i = 1; i <= 31; i++) {
			cbDay.addItem(i);
		}
		add(cbDay);

		JLabel lblMonth = new JLabel("Month");
		add(lblMonth);

		JComboBox cbMonth = new JComboBox();
		for (int i = 1; i <= 12; i++) {
			cbMonth.addItem(i);
		}
		add(cbMonth);

		JLabel lblYear = new JLabel("Year");

		add(lblYear);

		JComboBox cbYear = new JComboBox();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = year; i <= year + 2; i++) {
			cbYear.addItem(i);
		}
		add(cbYear);
	}

}