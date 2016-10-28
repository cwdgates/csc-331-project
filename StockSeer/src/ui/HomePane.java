package ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.HomePaneController;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Component;

public class HomePane extends JPanel {
	private JButton btnCreateLeague;
	private JButton btnJoinLeague;
	private JButton btnManageLeagues;
	private JButton btnLogout;

	public static final String CREATE_LEAGUE = "Create a League";
	public static final String JOIN_LEAGUE = "Join A League";
	public static final String MANAGE_LEAGUE = "Manage Leagues";
	public static final String LOGOUT = "Logout";

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

		btnCreateLeague = new JButton(CREATE_LEAGUE);
		btnCreateLeague.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelControl.add(btnCreateLeague);

		btnJoinLeague = new JButton(JOIN_LEAGUE);
		btnJoinLeague.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelControl.add(btnJoinLeague);

		btnManageLeagues = new JButton(MANAGE_LEAGUE);
		btnManageLeagues.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelControl.add(btnManageLeagues);

		btnLogout = new JButton(LOGOUT);
		springLayout.putConstraint(SpringLayout.NORTH, btnLogout, 6, SpringLayout.SOUTH, panelControl);
		springLayout.putConstraint(SpringLayout.WEST, btnLogout, 0, SpringLayout.WEST, this);
		add(btnLogout);

	}

	public void registerListeners(HomePaneController homePaneController) {
		btnCreateLeague.addActionListener(homePaneController);
		btnJoinLeague.addActionListener(homePaneController);
		btnManageLeagues.addActionListener(homePaneController);
		btnLogout.addActionListener(homePaneController);
	}

}
