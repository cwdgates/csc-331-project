package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import ui.AppView;

public class LogoutController implements ActionListener {
	private AppView appView;

	public LogoutController(AppView appView) {
		this.appView = appView;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int choice = JOptionPane.showConfirmDialog(appView, "Are you sure you want to logout?", "",
				JOptionPane.OK_CANCEL_OPTION);
		switch (choice) {
			case JOptionPane.OK_OPTION:
				appView.viewLogin();
				break;
			case JOptionPane.CANCEL_OPTION:
				break;
			default:
				break;
		}
	}

}
