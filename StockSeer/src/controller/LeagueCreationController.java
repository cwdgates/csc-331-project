package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;
import ui.LeagueCreationPane;

public class LeagueCreationController implements ActionListener {
	AppView appView;
	LeagueCreationPane createLeaguePane;

	public LeagueCreationController(AppView appView) {
		this.appView = appView;
		this.createLeaguePane = appView.getCreateLeaguePane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case LeagueCreationPane.CREATE: {
			System.out.println(LeagueCreationPane.CREATE);
			break;
		}
		case LeagueCreationPane.CANCEL: {
			System.out.println(LeagueCreationPane.CANCEL);
			appView.viewHome();
			break;
		}

		default:
			break;
		}
	}

}
