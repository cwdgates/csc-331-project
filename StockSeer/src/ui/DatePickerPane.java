package ui;

import javax.swing.JPanel;
import org.joda.time.JodaTimePermission;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;

public class DatePickerPane extends JPanel {
	private JComboBox<String> cbMonth;
	private JComboBox<String> cbDay;
	private JComboBox<String> cbYear;

	/**
	 * Create the panel.
	 */
	public DatePickerPane() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JLabel lblMonth = new JLabel("Month");
		add(lblMonth);

		cbMonth = new JComboBox<String>();
		add(cbMonth);
		cbMonth.addItem("--");
		for (int i = 1; i <= 12; i++) {
			cbMonth.addItem(i + "");
		}

		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut);

		JLabel lblDay = new JLabel("Day");
		add(lblDay);

		cbDay = new JComboBox<String>();
		add(cbDay);
		cbDay.addItem("--");
		for (int i = 1; i <= 31; i++) {
			cbDay.addItem(i + "");
		}

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1);

		JLabel lblYear = new JLabel("Year");
		add(lblYear);

		cbYear = new JComboBox<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		cbYear.addItem("--");
		for (int i = year; i <= year + 2; i++) {
			cbYear.addItem(i + "");
		}
		add(cbYear);
	}

	public Date getDate() {
		Date date = new Date();
		// FIXME working on date
		date.setMonth(Integer.parseInt((String) cbMonth.getSelectedItem()));

		return date;
	}
}
