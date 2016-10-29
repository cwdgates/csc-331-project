package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mysql.fabric.xmlrpc.base.Data;

public class DateModel extends GregorianCalendar {

	public DateModel() {
	}

	/**
	 * 
	 * @param year
	 * @param month
	 *            1-January and 12-December
	 * @param dayOfMonth
	 */
	public DateModel(int year, int month, int dayOfMonth) {
		super(year, month - 1, dayOfMonth);
	}

	/**
	 * create DateModel from string under this format<br>
	 * <b>YYYY-MM-DD</b>
	 * 
	 * @param mySQLdate
	 *            <b>YYYY-MM-DD</b>
	 */
	public DateModel(String mySQLdate) {
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
	 * @return YYYY-MM-DD
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
