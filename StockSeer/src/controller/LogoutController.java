package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.AppView;
import ui.HomePane;

public class LogoutController implements ActionListener {
	AppView appView;
	HomePane mainView;

	public LogoutController(AppView appView) {
		this.appView = appView;
		mainView = appView.getHomePane();
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
