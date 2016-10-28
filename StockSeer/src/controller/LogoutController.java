package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.LeagueListModel;
import ui.AppView;
import ui.HomePane;
import ui.MainPane;

public class LogoutController implements ActionListener {
	AppView appView;
	MainPane mainView;

	public LogoutController(AppView appView, LeagueListModel leagueList) {
		this.appView = appView;
		mainView = appView.getMainView();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int choice = JOptionPane.showConfirmDialog(appView, "Do you want to log out ?", "",
				JOptionPane.OK_CANCEL_OPTION);
		if (choice == JOptionPane.OK_OPTION) {
			appView.viewLogin();
		}
	}

}
