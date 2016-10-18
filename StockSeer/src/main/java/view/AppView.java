package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import util.CredentialUtil;

import java.awt.Dimension;
import java.awt.CardLayout;

public class AppView extends JFrame {

	// main panel
	private JPanel contentPane;

	private LoginPane loginPane;
	private HomePane homePane;
	private CreateLeaguePane createLeaguePane;
	private ChooseStockPane chooseStockPane;
	private DifficultyPane difficultyPane;

	// Components constraints
	private final String LOGIN_PANE = "LOGIN_PANE";
	private final String HOME_PANE = "HOME_PANE";
	private final String CREATE_LEAGUE_PANE = "CREATE_LEAGUE_PANE";
	private final String CHOOSE_STOCK_PANE = "CHOOSE_STOCK_PANE";
	private final String DIFFICULTY_PANE = "DIFFICULTY_PANE";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AppView(LoginPane loginPane) {
		// set look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		setMinimumSize(new Dimension(500, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(300, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		this.loginPane = loginPane;
		contentPane.add(loginPane, LOGIN_PANE);

		homePane = new HomePane();
		contentPane.add(homePane, HOME_PANE);

		difficultyPane = new DifficultyPane();
		contentPane.add(difficultyPane, DIFFICULTY_PANE);

		createLeaguePane = new CreateLeaguePane();
		contentPane.add(createLeaguePane, CREATE_LEAGUE_PANE);

		chooseStockPane = new ChooseStockPane();
		contentPane.add(chooseStockPane, CHOOSE_STOCK_PANE);

	}

}
