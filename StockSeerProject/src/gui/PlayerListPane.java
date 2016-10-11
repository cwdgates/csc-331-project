package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.Box;

public class PlayerListPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayerListPane() {
		setLayout(new MigLayout("", "[grow,center]", "[grow][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		JButton btnRefresh = new JButton("Refresh");
		add(btnRefresh, "flowx,cell 0 1,alignx leading");
		
		JButton btnInviteAPlayer = new JButton("Invite a player ...");
		add(btnInviteAPlayer, "cell 0 1,alignx trailing");
		
		JButton btnStart = new JButton("Start");
		add(btnStart, "cell 0 1,alignx trailing");
		
		JButton btnHome = new JButton("Home");
		add(btnHome, "cell 0 2,alignx right");

	}

}
