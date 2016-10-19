package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;
import ui.CreateLeaguePane;

public class CreateStockPaneController implements ActionListener {
	AppView appView;
	CreateLeaguePane createLeaguePane;

	public CreateStockPaneController(AppView appView) {
		this.appView = appView;
		this.createLeaguePane = appView.getCreateLeaguePane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case CreateLeaguePane.CREATE: {
			System.out.println(CreateLeaguePane.CREATE);
			break;
		}
		case CreateLeaguePane.CANCEL: {
			System.out.println(CreateLeaguePane.CANCEL);
			appView.viewHome();
			break;
		}

		default:
			break;
		}
	}

}
