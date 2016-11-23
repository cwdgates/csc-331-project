package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MainUserModel;
import model.LeagueListModel;
import model.PlayersListModel;
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
            case HomePane.CREATE_LEAGUE: {
                System.out.println(HomePane.CREATE_LEAGUE);
                appView.viewCreateLeaguePane();
                break;
            }
            
            case HomePane.REFRESH: {
                System.out.println(HomePane.REFRESH);
                
                leagueListModel.allLeagues();
                playersListModel.allPlayers();
                break;
            }
            
            case HomePane.LOGOUT: {
                System.out.println(HomePane.LOGOUT);
                int choice = JOptionPane.showConfirmDialog(appView, "Do you want to log out ?", "",
                        JOptionPane.OK_CANCEL_OPTION);
                if (choice == JOptionPane.OK_OPTION) {
                    appView.viewLogin();
                }
                break;
            }
            
            case HomePane.JOIN_LEAGUE: {
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
            }
            
            default:
                break;
        }
    }
    
}
