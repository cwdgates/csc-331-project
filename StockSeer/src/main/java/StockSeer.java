import controller.LoginController;
import model.CredentialUtil;
import view.*;

public class StockSeer {

	public static void main(String[] args) {
		// init models
		CredentialUtil loginModel = new CredentialUtil();
		
		// init panels
		LoginPane loginPane = new LoginPane(loginModel);

		AppView view = new AppView(loginPane, loginModel);

		LoginController loginController = new LoginController(loginPane, loginModel);
		// panels register listeners
		loginPane.registerListeners(loginController);

		view.setVisible(true);

	}

}
