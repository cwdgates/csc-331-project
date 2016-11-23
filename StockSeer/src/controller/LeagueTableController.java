package controller;

import model.MainUserModel;
import view.AppView;
import view.HomePane;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

import model.LeagueListModel;

/**
 * Created by anvu on 11/8/16.
 */
public class LeagueTableController implements ItemListener {
	AppView view;
	LeagueListModel leagueListModel;
	MainUserModel mainUserModel;

	public LeagueTableController(AppView view, MainUserModel mainUserModel, LeagueListModel leagueListModel) {
		this.view = view;
		this.leagueListModel = leagueListModel;
		this.mainUserModel = mainUserModel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton button = (JRadioButton) e.getItem();
		if (e.getStateChange() == 1)
			switch (button.getText()) {
			case HomePane.RDBTN_ALL: {
				leagueListModel.allLeagues();
				break;
			}
			case HomePane.RDBTN_JOINED_LEAGUES: {
				System.out.println("Not available right now");
				break;
			}
			case HomePane.RDBTN_MY_LEAGUES: {
				leagueListModel.allLeaguesOwnedBy(mainUserModel.getUsername());
				break;
			}

			default:
				break;
			}

	}

}