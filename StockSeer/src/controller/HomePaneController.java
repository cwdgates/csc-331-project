package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CurrentUserModel;
import ui.AppView;
import ui._HomePane;

public class HomePaneController implements ActionListener {
	_HomePane homePane;
	AppView appView;
	CurrentUserModel userModel;

	public HomePaneController(AppView appView, CurrentUserModel userModel) {
		this.appView = appView;
		this.userModel = userModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case _HomePane.CREATE_LEAGUE: {
			System.out.println(_HomePane.CREATE_LEAGUE);
			appView.viewCreateLeaguePane();
			break;
		}

		case _HomePane.JOIN_LEAGUE: {
			System.out.println(_HomePane.JOIN_LEAGUE);
			break;
		}

		case _HomePane.MANAGE_LEAGUE: {
			System.out.println(_HomePane.MANAGE_LEAGUE);
			break;
		}

		case _HomePane.LOGOUT: {
			System.out.println(_HomePane.LOGOUT);
			int choice = JOptionPane.showConfirmDialog(appView, "Do you want to log out ?", "",
					JOptionPane.OK_CANCEL_OPTION);
			if (choice == JOptionPane.OK_OPTION) {
				System.out.println("User: " + (userModel == null ? true : false));
				appView.viewLogin();
			}

			break;
		}

		default:
			break;
		}
	}

}
