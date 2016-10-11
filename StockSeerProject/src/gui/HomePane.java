package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class HomePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePane() {
		setLayout(new MigLayout("", "[]", "[][][]"));
		
		JButton btnCreateALeague = new JButton("Create a League");
		add(btnCreateALeague, "cell 0 0");
		
		JButton btnJoinALeague = new JButton("Join a League");
		add(btnJoinALeague, "cell 0 1");
		
		JButton btnManageLeagues = new JButton("Manage Leagues");
		add(btnManageLeagues, "cell 0 2");
		
	}

}
