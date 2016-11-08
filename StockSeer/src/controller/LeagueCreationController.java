package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;

import persistence.Date;
import persistence.LeagueUtility;
import view.AppView;
import view.LeagueCreationPane;
import model.AccountModel;
import model.Difficulty;

/**
 *
 */
public class LeagueCreationController implements ActionListener {
    private AppView appView;
    private LeagueCreationPane createLeaguePane;
    private AccountModel accountModel;

    public LeagueCreationController(AppView appView) {
        this.appView = appView;
        this.createLeaguePane = appView.getCreateLeaguePane();
        this.accountModel = accountModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            // CREATE button clicked
            case LeagueCreationPane.CREATE: {
                System.out.println(LeagueCreationPane.CREATE);
                // check name
                if (createLeaguePane.getLeagueName().length() == 0) {
                    JOptionPane.showMessageDialog(appView, "Please enter the name of the league.", "",
                            JOptionPane.WARNING_MESSAGE);
                } else if (!LeagueUtility.isLeagueUnique(createLeaguePane.getLeagueName())) {
                    JOptionPane.showMessageDialog(appView,
                            "The name has been used in another league.\nPlease use another name.", "",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    Date startDate = createLeaguePane.getStartDate();
                    Date endDate = createLeaguePane.getEndDate();
                    // check start date
                    if (startDate == null) {
                        JOptionPane.showMessageDialog(appView, "Start date is invalid.", "", JOptionPane
                                .WARNING_MESSAGE);
                    }
                    // check end date
                    else if (endDate == null) {
                        JOptionPane.showMessageDialog(appView, "End date is invalid.", "", JOptionPane.WARNING_MESSAGE);
                    }
                    // make sure end date is after start date
                    else if (!endDate.after(startDate)) {
                        System.out.println(startDate.get(Calendar.DATE) + "-" + startDate.get(Calendar.MONTH) + "-"
                                + startDate.get(Calendar.YEAR));
                        System.out.println(endDate.get(Calendar.DATE) + "-" + endDate.get(Calendar.MONTH) + "-"
                                + endDate.get(Calendar.YEAR));
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
                            boolean isSuccess = LeagueUtility.createLeague(name, capacity, startDate, endDate,
									difficulty, accountModel.getUsername());
                            if (isSuccess) {
                                JOptionPane.showMessageDialog(appView, "The league was successfully created.", "",
                                        JOptionPane.INFORMATION_MESSAGE);
                                createLeaguePane.resetFields();
                                appView.viewHome();
                            } else {
                                JOptionPane.showMessageDialog(appView, "The league was NOT successfully created.", "",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                }

                break;
            }
            // CANCEL button clicked
            case LeagueCreationPane.CANCEL: {
                System.out.println(LeagueCreationPane.CANCEL);
                int choice = JOptionPane.showConfirmDialog(appView, "Do you want to cancel?", "",
                        JOptionPane.OK_CANCEL_OPTION);
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
}
