import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.HomePaneController;
import controller.LeagueCreationController;
import controller.LoginController;
import controller.RegistrationController;
import model.CurrentUserModel;
import model.LeagueListModel;
import persistence.DBConnection;
import view.AppView;;

/**
 * App runner
 * 
 * @author aqv
 *
 */
public class StockSeer {
	// view ------------------
	private AppView appView;

	// controllers --------------------
	private LoginController loginController;
	private RegistrationController registrationController;
	private LeagueCreationController leagueCreationController;
	private HomePaneController homePaneController;

	// models ---------------------
	private CurrentUserModel userModel = null; // only one user per instance of
	// application
	private LeagueListModel leagueListModel = null;

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

		// ------------------- INITIALIZE VIEW -----------------------
		appView = new AppView();

		// ------------------- INITIALIZE MODELS ---------------------
		leagueListModel = new LeagueListModel();

		// ----------------- INITIALIZE CONTROLLERS -----------------
		loginController = new LoginController(appView, userModel);
		registrationController = new RegistrationController(appView);
		leagueCreationController = new LeagueCreationController(appView, userModel);
		homePaneController = new HomePaneController(appView);

		// --------------------REGISTER LISTENERS --------------------------
		appView.getLoginPane().registerListeners(loginController);
		appView.getCreateLeaguePane().registerListeners(leagueCreationController);
		appView.getSignUpPane().registerListeners(registrationController);
		appView.getHomePane().registerListeners(homePaneController);

		// -------------------- SET VISIBLE -------------------------
		appView.setVisible(true);
	}

	public static void main(String[] args) {
		StockSeer stockSeer = new StockSeer();
		stockSeer.run();
	}

}
