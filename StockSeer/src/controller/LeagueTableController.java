package controller;

import view.AppView;
import view.HomePane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JRadioButton;

import model.AccountModel;
import model.LeagueListModel;

/**
 * Created by anvu on 11/8/16.
 */
public class LeagueTableController implements ItemListener {
	AppView view;
	LeagueListModel leagueListModel;
	AccountModel accountModel;

	public LeagueTableController(AppView view, AccountModel accountModel, LeagueListModel leagueListModel) {
		this.view = view;
		this.leagueListModel = leagueListModel;
		this.accountModel = accountModel;
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
				leagueListModel.allLeaguesOwnedBy(accountModel.getUsername());
				break;
			}

			default:
				break;
			}

	}

}