package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.HomePane;

public class HomePaneController implements ActionListener {
	HomePane homePane;

	public HomePaneController(HomePane homePane) {
		this.homePane = homePane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case HomePane.CREATE_LEAGUE: {
			System.out.println("Create Leauge");
			break;
		}

		case HomePane.JOIN_LEAGUE: {
			System.out.println("Join League");
			break;
		}

		default:
			break;
		}
	}

}
