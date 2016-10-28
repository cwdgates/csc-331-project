package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import model.UserModel;
import ui.AppView;
import ui.LeagueCreationPane;

public class LeagueCreationController implements ActionListener {
	AppView appView;
	LeagueCreationPane createLeaguePane;
	UserModel userModel;

	public LeagueCreationController(AppView appView, UserModel userModel) {
		this.appView = appView;
		this.createLeaguePane = appView.getCreateLeaguePane();
		this.userModel = userModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		// CREATE button clicked
		case LeagueCreationPane.CREATE: {
			System.out.println(LeagueCreationPane.CREATE);
			// check name
			if (createLeaguePane.getLeagueName().length() == 0) {
				JOptionPane.showMessageDialog(appView, "Please enter the name of the league.", "",
						JOptionPane.WARNING_MESSAGE);
			} else {
				GregorianCalendar startDate = createLeaguePane.getStartDate();
				GregorianCalendar endDate = createLeaguePane.getEndDate();
				// check start date
				if (startDate == null) {
					JOptionPane.showMessageDialog(appView, "Start date is invalid.", "", JOptionPane.WARNING_MESSAGE);
				}
				// check end date
				else if (endDate == null) {
					JOptionPane.showMessageDialog(appView, "End date is invalid.", "", JOptionPane.WARNING_MESSAGE);
				}
				// make sure end date is after start date
				else if (!endDate.after(startDate)) {
					System.out.println(startDate.get(Calendar.DATE) + "-" + startDate.get(Calendar.MONTH) + "-"
							+ startDate.get(Calendar.YEAR));
					System.out.println(endDate.get(Calendar.DATE) + "-" + endDate.get(Calendar.MONTH) + "-"
							+ endDate.get(Calendar.YEAR));
					JOptionPane.showMessageDialog(appView, "End date is not after start date.", "",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// finally get a chance to create league
					int choice = JOptionPane.showConfirmDialog(appView, "Do you want to create this league?", "",
							JOptionPane.OK_CANCEL_OPTION);
					if (choice == JOptionPane.OK_OPTION) {
						createLeague();
					}
				}
			}

			break;
		}
		// CANCEL button clicked
		case LeagueCreationPane.CANCEL: {
			System.out.println(LeagueCreationPane.CANCEL);
			appView.viewHome();
			break;
		}

		default:
			break;
		}
	}

	private void createLeague() {
		System.out.println("Start creating league...");
	}
}
