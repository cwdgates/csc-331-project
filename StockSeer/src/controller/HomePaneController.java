package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.League;
import model.AccountModel;
import persistence.AccountUtility;
import persistence.LeagueUtility;
import view.AppView;
import view.HomePane;

public class HomePaneController implements ActionListener {
	private AppView appView;
	private HomePane homePane;
	private AccountModel accountModel;

	public HomePaneController(AppView appView, AccountModel accountModel) {
		this.appView = appView;
		this.homePane = appView.getHomePane();
		this.accountModel = accountModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case HomePane.CREATE_LEAGUE: {
			System.out.println(HomePane.CREATE_LEAGUE);
			appView.viewCreateLeaguePane();
			break;
		}

		case HomePane.REFRESH: {
			System.out.println(HomePane.REFRESH);
			System.out.println(accountModel); // FIXME debug
			ArrayList<League> leagues = LeagueUtility.getAllLeaguesFromDB();
			if (leagues != null) {
				Vector<Vector<String>> tableData = new Vector<>();
				for (League league : leagues) {
					Vector<String> row = new Vector<>();
					row.add(league.getName());
					row.add(league.getStartDate().toString());
					row.add(league.getEndDate().toString());
					row.add(league.getCapacity() + "");
					row.add(league.getDifficulty().name());
					tableData.add(row);
				}

				appView.getHomePane().setTableData(tableData);
			}
			break;
		}

		case HomePane.LOGOUT: {
			System.out.println(HomePane.LOGOUT);
			int choice = JOptionPane.showConfirmDialog(appView, "Do you want to log out ?", "",
					JOptionPane.OK_CANCEL_OPTION);
			if (choice == JOptionPane.OK_OPTION) {
				appView.viewLogin();
			}
			break;
		}

		case HomePane.JOIN_LEAGUE: {
			// FIXME still working
			System.out.println(homePane.getLeagueSelected());
			String league = homePane.getLeagueSelected();
			if (league != null) {
				int choice = JOptionPane.showConfirmDialog(appView, "Do you want to join " + league + " ?", "",
						JOptionPane.OK_CANCEL_OPTION);
				if (choice == JOptionPane.OK_OPTION) {
					System.out.println("****" + accountModel.getUsername());
					AccountUtility.joinLeague(accountModel.getUsername(),league);
				}
			}

			break;
		}

		default:
			break;
		}
	}

}
