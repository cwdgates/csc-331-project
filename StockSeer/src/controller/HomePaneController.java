package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CurrentUserModel;
import ui.AppView;
import ui.HomePane;

public class HomePaneController implements ActionListener {
	HomePane homePane;
	AppView appView;
	CurrentUserModel userModel;

	public HomePaneController(AppView appView, CurrentUserModel userModel) {
		this.appView = appView;
		this.homePane = appView.getHomePane();
		this.userModel = userModel;
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

			case HomePane.JOIN_LEAGUE: {
				System.out.println(HomePane.JOIN_LEAGUE);
				break;
			}

			case HomePane.MANAGE_LEAGUE: {
				System.out.println(HomePane.MANAGE_LEAGUE);
				break;
			}

			case HomePane.LOGOUT: {
				System.out.println(HomePane.LOGOUT);
				System.out.println((userModel == null ? true : false));
//				userModel.setFieldsNull();
				appView.viewLogin();
				break;
			}

			default:
				break;
		}
	}

}
