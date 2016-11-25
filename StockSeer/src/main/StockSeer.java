package main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.*;
import model.MainUserModel;
import view.renderModel.LeagueListModel;
import view.renderModel.PlayersListModel;
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
        MainUserModel mainUserModel = new MainUserModel(); // only one user per instance of
        LeagueListModel leagueListModel = new LeagueListModel();
        PlayersListModel playersListModel = new PlayersListModel();
        
        // ----------------- INITIALIZE CONTROLLERS -----------------
        LoginController loginController = new LoginController(appView, mainUserModel, leagueListModel);
        RegistrationController registrationController = new RegistrationController(appView);
        HomePaneController homePaneController = new HomePaneController(appView, mainUserModel, leagueListModel, playersListModel);
        LeagueCreationController leagueCreationController = new LeagueCreationController(appView, mainUserModel, leagueListModel);
        LeagueTableController leagueTableFilterController = new LeagueTableController(appView, mainUserModel, leagueListModel);
        ChooseStockController chooseStockController = new ChooseStockController(appView.getCreateLeaguePane());
        
        // --------------------REGISTER LISTENERS --------------------------
        appView.getLoginPane().registerListeners(loginController);
        appView.getCreateLeaguePane().registerListeners(leagueCreationController);
        appView.getSignUpPane().registerListeners(registrationController);
        appView.getHomePane().registerListeners(homePaneController);
        appView.getHomePane().registerRadioButtonListeners(leagueTableFilterController);
        appView.getCreateLeaguePane().registerListeners(chooseStockController);
        
        appView.getHomePane().setLeagueTableModel(leagueListModel);
        appView.getHomePane().setPlayersListTableModel(playersListModel);
        
        // -------------------- SET VISIBLE -------------------------
        appView.setVisible(true);
    }
    
    public static void main(String[] args) {
        StockSeer stockSeer = new StockSeer();
        stockSeer.run();
    }
    
}
