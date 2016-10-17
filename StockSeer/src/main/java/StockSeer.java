import controller.LoginController;
import model.CredentialModel;
import view.*;

public class StockSeer {

	public static void main(String[] args) {
		// init models
		CredentialModel loginModel = new CredentialModel();
		
		// init panels
		LoginPane loginPane = new LoginPane(loginModel);

		AppView view = new AppView(loginPane, loginModel);

		LoginController loginController = new LoginController(loginPane, loginModel);
		// panels register listeners
		loginPane.registerListeners(loginController);

		view.setVisible(true);

	}

}
