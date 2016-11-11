package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.League;
import model.AccountModel;
import model.LeagueListModel;
import model.PlayersListModel;
import persistence.AccountUtility;
import persistence.LeagueUtility;
import view.AppView;
import view.HomePane;

public class HomePaneController implements ActionListener {
	private AppView appView;
	private HomePane homePane;
	private AccountModel accountModel;
	private LeagueListModel leagueListModel;
	private PlayersListModel playersListModel;

	public HomePaneController(AppView appView, AccountModel accountModel, LeagueListModel leagueListModel,
			PlayersListModel playersListModel) {
		this.appView = appView;
		this.homePane = appView.getHomePane();
		this.accountModel = accountModel;
		this.leagueListModel = leagueListModel;
		this.playersListModel = playersListModel;
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

			leagueListModel.allLeagues();
			playersListModel.allPlayers();
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
			String league = homePane.getLeagueSelected();
			if (league != null) {
				int choice = JOptionPane.showConfirmDialog(appView, "Do you want to join " + league + " ?", "",
						JOptionPane.OK_CANCEL_OPTION);
				if (choice == JOptionPane.OK_OPTION) {
					AccountUtility.joinLeague(accountModel.getUsername(), league);
				}
			}

			break;
		}

		default:
			break;
		}
	}

}
