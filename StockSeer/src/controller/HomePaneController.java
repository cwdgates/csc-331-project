package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MainUserModel;
import view.LeagueInfoPane;
import view.renderModel.LeagueListModel;
import view.renderModel.PlayersListModel;
import persistence.AccountUtility;
import view.AppView;
import view.HomePane;

public class HomePaneController implements ActionListener {
    private AppView appView;
    private HomePane homePane;
    private MainUserModel mainUserModel;
    private LeagueListModel leagueListModel;
    private PlayersListModel playersListModel;
    
    public HomePaneController(AppView appView, MainUserModel mainUserModel, LeagueListModel leagueListModel,
                              PlayersListModel playersListModel) {
        this.appView = appView;
        this.homePane = appView.getHomePane();
        this.mainUserModel = mainUserModel;
        this.leagueListModel = leagueListModel;
        this.playersListModel = playersListModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case HomePane.BTN_CREATE_LEAGUE: {
                System.out.println(HomePane.BTN_CREATE_LEAGUE);
                appView.viewCreateLeaguePane();
                break;
            }
            
            case HomePane.BTN_REFRESH: {
                System.out.println(HomePane.BTN_REFRESH);
                
                leagueListModel.allLeagues();
                playersListModel.allPlayers();
                break;
            }
            
            case HomePane.BTN_LOGOUT: {
                System.out.println(HomePane.BTN_LOGOUT);
                int choice = JOptionPane.showConfirmDialog(appView, "Do you want to log out ?", "",
                        JOptionPane.OK_CANCEL_OPTION);
                if (choice == JOptionPane.OK_OPTION) {
                    appView.viewLogin();
                }
                break;
            }
            
            case HomePane.BTN_JOIN_LEAGUE: {
                // FIXME still working
                String league = homePane.getLeagueSelected();
                if (league != null) {
                    int choice = JOptionPane.showConfirmDialog(appView, "Do you want to join " + league + " ?", "",
                            JOptionPane.OK_CANCEL_OPTION);
                    if (choice == JOptionPane.OK_OPTION) {
                        AccountUtility.joinLeague(mainUserModel.getUsername(), league);
                    }
                }
                
                break;
            }
            
            case HomePane.ALL_PLAYERS: {
                System.out.println("ALL PLAYER");
                playersListModel.allPlayers();
                break;
            }
            
            case HomePane.BTN_DETAIL:{
                System.out.println("DETAIL");
                LeagueInfoPane.show("");
                break;
            }
            
            default:
                break;
        }
    }
    
}
