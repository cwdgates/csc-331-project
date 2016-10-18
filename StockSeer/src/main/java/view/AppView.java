package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

public class AppView extends JFrame {

	private JPanel contentPane; // main panel

	private LoginPane loginPane;
	private HomePane homePane;
	private CreateLeaguePane createLeaguePane;
	private ChooseStockPane chooseStockPane;
	private DifficultyPane difficultyPane;
	private CardLayout cardLayout;

	// Components constraints
	private final String LOGIN_PANE = "LOGIN_PANE";
	private final String HOME_PANE = "HOME_PANE";
	private final String CREATE_LEAGUE_PANE = "CREATE_LEAGUE_PANE";
	private final String CHOOSE_STOCK_PANE = "CHOOSE_STOCK_PANE";
	private final String DIFFICULTY_PANE = "DIFFICULTY_PANE";

	/**
	 * Create the frame.
	 */
	public AppView() {
		setTitle("Stock Seer");
		setMinimumSize(new Dimension(500, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(300, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		loginPane = new LoginPane();
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

	public void viewLogin() {
		cardLayout.show(contentPane, LOGIN_PANE);
	}

	public void viewHome() {
		cardLayout.show(contentPane, HOME_PANE);
		System.out.println("Switched to home pane");
	}

	public void viewDifficultyPane() {
		cardLayout.show(contentPane, DIFFICULTY_PANE);
	}

	public void viewCreateLeaguePane() {
		cardLayout.show(contentPane, CREATE_LEAGUE_PANE);
	}

	public void viewChooseStockPane() {
		cardLayout.show(contentPane, CHOOSE_STOCK_PANE);
	}

	public LoginPane getLoginPane() {
		return loginPane;
	}

	public HomePane getHomePane() {
		return homePane;
	}

	public ChooseStockPane getChooseStockPane() {
		return chooseStockPane;
	}

	public CreateLeaguePane getCreateLeaguePane() {
		return createLeaguePane;
	}
}
