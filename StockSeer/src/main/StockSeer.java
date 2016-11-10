package main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.*;
import model.AccountModel;
import model.LeagueListModel;
import persistence.DBConnection;
import view.AppView;;
//

/**
 * App runner
 *
 * @author aqv
 */
public class StockSeer {
    
    // models ---------------------
    
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
        AppView appView = new AppView();
        
        // ------------------- INITIALIZE MODELS ---------------------
        AccountModel accountModel = new AccountModel(); // only one user per instance of
        LeagueListModel leagueListModel = new LeagueListModel();
        
        // ----------------- INITIALIZE CONTROLLERS -----------------
        LoginController loginController = new LoginController(appView, accountModel, leagueListModel);
        RegistrationController registrationController = new RegistrationController(appView);
        HomePaneController homePaneController = new HomePaneController(appView, accountModel, leagueListModel);
        LeagueCreationController leagueCreationController = new LeagueCreationController(appView, accountModel, leagueListModel);
        LeagueTableController leagueTableFilterController = new LeagueTableController(appView, accountModel, leagueListModel);
        
        // --------------------REGISTER LISTENERS --------------------------
        appView.getLoginPane().registerListeners(loginController);
        appView.getCreateLeaguePane().registerListeners(leagueCreationController);
        appView.getSignUpPane().registerListeners(registrationController);
        appView.getHomePane().registerListeners(homePaneController);
        appView.getHomePane().registerRadioButtonListeners(leagueTableFilterController);
        appView.getHomePane().setDefaultTableModel(leagueListModel);
        
        // -------------------- SET VISIBLE -------------------------
        appView.setVisible(true);
    }
    
    public static void main(String[] args) {
        StockSeer stockSeer = new StockSeer();
        stockSeer.run();
    }
    
}
