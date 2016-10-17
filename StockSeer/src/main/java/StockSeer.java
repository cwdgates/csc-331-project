import javax.swing.JOptionPane;

import controller.LoginController;
import util.CredentialUtil;
import util.DbUtil;
import view.*;

/**
 * App runner
 * 
 * @author aqv
 *
 */
public class StockSeer {

	public static void main(String[] args) {
		// init models
		if (DbUtil.getConnection() == null){
			JOptionPane.showMessageDialog(null, "Can't connect to database.", "Database Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		CredentialUtil loginModel = new CredentialUtil();

		// init panels
		LoginPane loginPane = new LoginPane(loginModel);

		AppView view = new AppView(loginPane);

		LoginController loginController = new LoginController(loginPane, loginModel);
		// panels register listeners
		loginPane.registerListeners(loginController);

		view.setVisible(true);

	}

}
