package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class AppFrame extends JFrame {

	private JPanel contentPane;
	private LoginPane loginPane;
	private HomePane homePane;
	private CreateLeaguePane createLeaguePane;
	private ChooseStockPane chooseStockPane;

	private final String LOGIN_PANE = "LOGIN_PANE";
	private final String HOME_PANE = "HOME_PANE";
	private final String CREATE_LEAGUE_PANE = "CREATE_LEAGUE_PANE";
	private final String CHOOSE_STOCK_PANE = "CHOOSE_STOCK_PANE";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFrame frame = new AppFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		setMinimumSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(300, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		loginPane = new LoginPane();
		contentPane.add(loginPane, LOGIN_PANE);

		homePane = new HomePane();
		contentPane.add(homePane, HOME_PANE);

		createLeaguePane = new CreateLeaguePane();
		contentPane.add(createLeaguePane, CREATE_LEAGUE_PANE);

		chooseStockPane = new ChooseStockPane();
		contentPane.add(chooseStockPane, CHOOSE_STOCK_PANE);

	}

}
