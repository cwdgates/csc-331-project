package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import view.renderModel.LeagueListModel;
import model.MainUserModel;
import model.Date;
import persistence.LeagueUtility;
import view.AppView;
import view.LeagueCreationPane;
import model.Difficulty;

/**
 *
 */
public class LeagueCreationController implements ActionListener {
    private AppView appView;
    private LeagueCreationPane createLeaguePane;
    private MainUserModel mainUserModel;
    private LeagueListModel leagueListModel;
    
    public LeagueCreationController(AppView appView, MainUserModel mainUserModel, LeagueListModel leagueListModel) {
        this.appView = appView;
        this.createLeaguePane = appView.getCreateLeaguePane();
        this.mainUserModel = mainUserModel;
        this.leagueListModel = leagueListModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            /**
             * when BTN_CREATE button is clicked
             */
            case LeagueCreationPane.BTN_CREATE: {
                createLeague();
                break;
            }
            case LeagueCreationPane.BTN_CANCEL: {
                System.out.println(LeagueCreationPane.BTN_CANCEL);
                int choice = JOptionPane.showConfirmDialog(appView, "Do you want to cancel?", "",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.OK_OPTION) {
                    appView.viewHome();
                    createLeaguePane.resetFields();
                }
                break;
            }
            
            default:
                break;
        }
    }
    
    private void createLeague() {
        if (createLeaguePane.getLeagueName().length() == 0) {
            JOptionPane.showMessageDialog(appView, "Please enter the name of the league.", "",
                    JOptionPane.WARNING_MESSAGE);
        } else if (LeagueUtility.hasLeague(createLeaguePane.getLeagueName())) {
            JOptionPane.showMessageDialog(appView,
                    "The name has been used in another league.\nPlease use another name.", "",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            Date startDate = createLeaguePane.getStartDate();
            Date endDate = createLeaguePane.getEndDate();
            Date currentDate = new Date();
            // check start date
            if (startDate == null || startDate.before(currentDate)) {
                JOptionPane.showMessageDialog(appView, "Start date is invalid.", "", JOptionPane
                        .WARNING_MESSAGE);
            }
            // check end date
            else if (endDate == null) {
                JOptionPane.showMessageDialog(appView, "End date is invalid.", "", JOptionPane.WARNING_MESSAGE);
            }
            // make sure end date is after start date
            else if (!endDate.after(startDate)) {
                JOptionPane.showMessageDialog(appView, "End date is not after start date.", "",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                // finally get a chance to create league
                int choice = JOptionPane.showConfirmDialog(appView, "Do you want to create this league?", "",
                        JOptionPane.OK_CANCEL_OPTION);
                if (choice == JOptionPane.OK_OPTION) {
                    String name = createLeaguePane.getLeagueName();
                    int capacity = createLeaguePane.getCapacity();
                    Difficulty difficulty = createLeaguePane.getDifficulty();
                    boolean isCreateLeague = LeagueUtility.createLeague(name, capacity, startDate, endDate,
                            difficulty, mainUserModel.getUsername());
                    
                    boolean isAssignStock = LeagueUtility.assignStocks(createLeaguePane.getLeagueName(),
                            createLeaguePane.getStocks());
                    
                    if (isCreateLeague && isAssignStock) {
                        JOptionPane.showMessageDialog(appView, "The league was successfully created.", "",
                                JOptionPane.INFORMATION_MESSAGE);
                        createLeaguePane.resetFields();
                        leagueListModel.allLeagues();
                        appView.viewHome();
                    } else {
                        JOptionPane.showMessageDialog(appView, "The league was NOT successfully created.", "",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        
    }
}
