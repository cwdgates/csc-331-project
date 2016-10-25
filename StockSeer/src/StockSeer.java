import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.LeagueCreationController;
import controller.HomePaneController;
import controller.LoginController;
import controller.LogoutController;
import controller.RegistrationController;
import model.CredentialModel;
import model.UserModel;
import persistence.DBConnection;
import ui.*;

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
	private HomePaneController homePaneController;
	private LeagueCreationController leagueCreationController;
	private LogoutController logoutController;

	// models ---------------------
	private UserModel userModel; // only one user per instance of application

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
		userModel = new UserModel();

		// ----------------- INITIALIZE CONTROLLERS -----------------
		loginController = new LoginController(appView);
		registrationController = new RegistrationController(appView);
		homePaneController = new HomePaneController(appView);
		leagueCreationController = new LeagueCreationController(appView);
		logoutController = new LogoutController(appView);

		// --------------------ASSIGNMENT --------------------------
		appView.getLoginPane().registerListeners(loginController);
		appView.getHomePane().registerListeners(homePaneController, logoutController);
		appView.getCreateLeaguePane().registerListeners(leagueCreationController);
		appView.getSignUpPane().registerListeners(registrationController);

		// -------------------- SET VISIBLE -------------------------
		appView.setVisible(true);
	}

	public static void main(String[] args) {
		StockSeer stockSeer = new StockSeer();
		stockSeer.run();
	}

}
