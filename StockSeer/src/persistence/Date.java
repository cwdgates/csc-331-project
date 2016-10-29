package persistence;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date extends GregorianCalendar {

	public Date() {
	}

	/**
	 * 
	 * @param year
	 * @param month
	 *            Start from 1 (January)
	 * @param dayOfMonth
	 *            Start from 1
	 */
	public Date(int year, int month, int dayOfMonth) {
		super(year, month - 1, dayOfMonth);
	}

	/**
	 * create DateModel from string under this format<br>
	 * <b>YYYY-MM-DD</b>
	 * 
	 * @param mySQLdate
	 *            <b>YYYY-MM-DD</b>
	 */
	public Date(String mySQLdate) {
		super();
		String[] date = mySQLdate.split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]) - 1;
		int dayOfMonth = Integer.parseInt(date[2]);
		this.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		this.set(Calendar.MONTH, month);
		this.set(Calendar.YEAR, year);
	}

	/**
	 * @param field
	 * @param value
	 *            If value is month, then it should be 1 for January, and 12 for
	 *            December
	 */
	public void set(int field, int value) {
		if (field == Calendar.MONTH) {
			super.set(field, value - 1);
		}
	}

	/**
	 * @return YYYY-MM-DD. This can be used for SQL Date
	 */
	public String toString() {
		int day = this.get(Calendar.DATE);
		// GregorianCalendar month from 0-11
		int month = this.get(Calendar.MONTH) + 1;
		int year = this.get(Calendar.YEAR);
		String dd = (day + "").length() == 2 ? (day + "") : ("0" + day);
		String mm = (month + "").length() == 2 ? (month + "") : ("0" + month);
		return year + "-" + mm + "-" + dd;
	}
}
