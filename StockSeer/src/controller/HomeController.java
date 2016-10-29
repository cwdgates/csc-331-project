package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;
import ui.HomePane;

public class HomeController implements ActionListener {
	AppView appView;
	HomePane homePane = appView.getHomePane();

	public HomeController(AppView appView) {
		this.appView = appView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case HomePane.CREATE_LEAGUE:
			appView.viewCreateLeaguePane();
			break;

		case HomePane.JOIN_LEAGUE:
			
			break;

		default:
			break;
		}
	}

}
