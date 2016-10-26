package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.UserModel;
import ui.AppView;

public class LogoutController implements ActionListener {
	private AppView appView;
	private UserModel userModel;

	public LogoutController(AppView appView, UserModel userModel) {
		this.appView = appView;
		this.userModel = userModel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int choice = JOptionPane.showConfirmDialog(appView, "Are you sure you want to logout?", "",
				JOptionPane.OK_CANCEL_OPTION);
		switch (choice) {
		case JOptionPane.OK_OPTION:
			userModel.setFieldsNull();
			appView.viewLogin();
			break;
		case JOptionPane.CANCEL_OPTION:
			break;
		default:
			break;
		}
	}

}
