package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Component;

public class HomePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePane() {
		try {
			UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMinimumSize(new Dimension(300, 200));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JPanel panelControl = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelControl, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panelControl, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panelControl, -35, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panelControl, -10, SpringLayout.EAST, this);
		add(panelControl);
		panelControl.setLayout(new BoxLayout(panelControl, BoxLayout.Y_AXIS));
		
		JButton btnCreateLeague = new JButton("Create a League");
		btnCreateLeague.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelControl.add(btnCreateLeague);
		
		JButton btnJoinLeague = new JButton("Join A League");
		btnJoinLeague.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelControl.add(btnJoinLeague);
		
		JButton btnManageLeagues = new JButton("Manage Leagues");
		btnManageLeagues.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelControl.add(btnManageLeagues);
		
		JButton btnLogout = new JButton("Logout");
		springLayout.putConstraint(SpringLayout.NORTH, btnLogout, 6, SpringLayout.SOUTH, panelControl);
		springLayout.putConstraint(SpringLayout.WEST, btnLogout, 0, SpringLayout.WEST, this);
		add(btnLogout);

	}

}
