package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

import view.renderModel.LeagueListModel;
import model.MainUserModel;
import persistence.AccountUtility;
import view.AppView;
import view.LoginPane;

/**
 * know about actions performed
 *
 * @author aqv
 */
public class LoginController implements ActionListener, KeyListener {
    private LoginPane loginPane;
    private AppView appView;
    private MainUserModel mainUserModel;
    private LeagueListModel leagueListModel;
    
    public LoginController(AppView appView, MainUserModel mainUserModel, LeagueListModel leagueListModel) {
        this.loginPane = appView.getLoginPane();
        this.appView = appView;
        this.mainUserModel = mainUserModel;
        this.leagueListModel = leagueListModel;
    }
    
    public MainUserModel getMainUserModel() {
        return mainUserModel;
    }
    
    /**
     * check for button click in login panel
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch (command) {
            case LoginPane.LOGIN_BTN:
                if (validateFields()) {
                    performLogin();
                }
                break;
            case LoginPane.SIGNUP_BTN:
                appView.viewSignUp();
                break;
            
            default:
                break;
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        // if press enter key
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (validateFields()) {
                performLogin();
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    private void performLogin() {
        MainUserModel tempAccount = AccountUtility.getAccountFromDB(loginPane.getUsername(), loginPane.getPassword());
        if (tempAccount != null) {
            // show welcome pane
            mainUserModel.setUsername(tempAccount.getUsername());
            mainUserModel.setLastName(tempAccount.getLastName());
            mainUserModel.setFirstName(tempAccount.getFirstName());
            
            String msg = "Welcome " + mainUserModel.getFirstName() + " " + mainUserModel.getLastName() + ".\nClick OK to "
                    + "continue.";
            JOptionPane.showMessageDialog(appView, msg, "", JOptionPane.INFORMATION_MESSAGE);

            leagueListModel.allLeagues();
            appView.viewHome(); // change the scene to Home
            loginPane.setTextFieldsEmpty(); // clear text field
            
        } else {
            JOptionPane.showMessageDialog(loginPane, "Wrong username or password.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    /**
     * Check whether the username and password fields are empty
     *
     * @return <b>True</b> if username and password are not empty.<br>
     * <b>False</b> otherwise.
     */
    private boolean validateFields() {
        if (loginPane.getUsername().length() == 0 || loginPane.getPassword().length() == 0) {
            JOptionPane.showMessageDialog(loginPane, "Please fill in username and password.", "",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
