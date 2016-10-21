import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.CreatingLeagueController;
import controller.HomeController;
import controller.LoginController;
import controller.SignUpController;
import persistence.CredentialDao;
import persistence.DatabaseConnection;
import ui.*;

/**
 * App runner
 * 
 * @author aqv
 *
 */
public class StockSeer {

	public static void main(String[] args) {
		// set look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try to connect to database
		if (DatabaseConnection.getConnection() == null) {
			JOptionPane.showMessageDialog(null, "Can't connect to database.", "Database Error",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Can't connect to database.");
			return;
		}

		// init panels
		AppView appView = new AppView();

		LoginController loginController = new LoginController(appView);
		SignUpController signUpController = new SignUpController(appView);
		HomeController homePaneController = new HomeController(appView);
		CreatingLeagueController createStockPaneController = new CreatingLeagueController(appView);

		appView.getLoginPane().registerListeners(loginController);
		appView.getHomePane().registerListeners(homePaneController);
		appView.getCreateLeaguePane().registerListeners(createStockPaneController);
		appView.getSignUpPane().registerListeners(signUpController);

		appView.setVisible(true);

	}

}
