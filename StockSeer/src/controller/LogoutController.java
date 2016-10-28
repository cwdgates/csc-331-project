package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LeagueListModel;
import ui.AppView;
import ui.MainPane;

public class LogoutController implements ActionListener {
	AppView appView;
	MainPane mainView;
	LeagueListModel leagueList;
	
	public LogoutController(AppView view, LeagueListModel leagueList){
		this.appView = appView;
		mainView = appView.getMainView();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
