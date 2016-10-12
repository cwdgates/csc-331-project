package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateLeaguePane extends JPanel {
	private JTextField txtLeaguename;
	private JTextField textNumPlayers;
	private JTextField textStartDate;
	private JTextField textEndDate;
	private final ButtonGroup buttonGroupDifficulty = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public CreateLeaguePane() {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));
		
		JLabel lblLeagueName = new JLabel("League Name");
		add(lblLeagueName, "cell 0 0,alignx trailing");
		
		txtLeaguename = new JTextField();
		add(txtLeaguename, "cell 1 0,growx");
		txtLeaguename.setColumns(10);
		
		JLabel lblNumberOfPlayers = new JLabel("Number of Players");
		add(lblNumberOfPlayers, "cell 0 1,alignx trailing");
		
		textNumPlayers = new JTextField();
		add(textNumPlayers, "cell 1 1,growx");
		textNumPlayers.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start Date");
		add(lblStartDate, "cell 0 2,alignx trailing");
		
		textStartDate = new JTextField();
		add(textStartDate, "cell 1 2,growx");
		textStartDate.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End Date");
		add(lblEndDate, "cell 0 3,alignx trailing");
		
		textEndDate = new JTextField();
		add(textEndDate, "cell 1 3,growx");
		textEndDate.setColumns(10);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		add(lblDifficulty, "cell 0 4,alignx right");
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		buttonGroupDifficulty.add(rdbtnEasy);
		add(rdbtnEasy, "flowx,cell 1 4");
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		buttonGroupDifficulty.add(rdbtnMedium);
		add(rdbtnMedium, "cell 1 4");
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		buttonGroupDifficulty.add(rdbtnHard);
		add(rdbtnHard, "cell 1 4");
		
		JButton btnChooseStocks = new JButton("Choose Stocks ...");
		btnChooseStocks.setToolTipText("Validate above fields then redirect to Choose Stock Option Pane");
		btnChooseStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnChooseStocks, "cell 1 5");
		
		JButton btnCreateLeague = new JButton("Create League");
		add(btnCreateLeague, "cell 1 6");

	}

}
