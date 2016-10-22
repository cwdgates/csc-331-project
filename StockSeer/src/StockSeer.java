import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.LeagueCreationController;
import controller.HomePaneController;
import controller.LoginController;
import controller.RegistrationController;
import persistence.CredentialDao;
import persistence.DBConnection;
import ui.*;

/**
 * App runner
 * 
 * @author aqv
 *
 */
public class StockSeer {
	private LoginController loginController;
	private RegistrationController registrationController;
	private HomePaneController homePaneController;
	private LeagueCreationController leagueCreationController;
	private AppView appView;

	public void run() {
		// set look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try to connect to database
		if (DBConnection.getConnection() == null) {
			JOptionPane.showMessageDialog(null, "Can't connect to database.", "Database Error",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Can't connect to database.");
			return;
		}

		appView = new AppView();

		loginController = new LoginController(appView);
		registrationController = new RegistrationController(appView);
		homePaneController = new HomePaneController(appView);
		leagueCreationController = new LeagueCreationController(appView);

		appView.getLoginPane().registerListeners(loginController);
		appView.getHomePane().registerListeners(homePaneController);
		appView.getCreateLeaguePane().registerListeners(leagueCreationController);
		appView.getSignUpPane().registerListeners(registrationController);

		appView.setVisible(true);
	}

	public static void main(String[] args) {
		StockSeer stockSeer = new StockSeer();
		stockSeer.run();
	}

}
