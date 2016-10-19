package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AppView;

public class ViewController implements ActionListener {
	AppView appView;

	public ViewController(AppView appView) {
		this.appView = appView;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String command = event.getActionCommand();

		if (command == appView.getHomePane().CREATE_LEAGUE) {
			System.out.println("Create league");
		}
	}

}
