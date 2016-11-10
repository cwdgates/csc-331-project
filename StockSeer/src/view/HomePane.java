package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

import controller.HomePaneController;
import controller.LeagueTableController;

public class HomePane extends JPanel {
    
    /**
     * create NonEditableTableModel class in order to disable ability to edit
     * leagues data using GUI at Home Pane
     */
    
    public static final String CREATE_LEAGUE = "Create a league";
    public static final String JOIN_LEAGUE = "Join";
    public static final String LOGOUT = "Logout";
    public static final String REFRESH = "Refresh";
    public static final String DETAIL = "Detail";
    public static final String RDBTN_ALL = "All";
    public static final String RDBTN_MY_LEAGUES = "My leagues";
    public static final String RDBTN_JOINED_LEAGUES = "Joined leagues";
    private JButton btnCreate;
    private JButton btnLogout;
    private JButton btnJoin;
    private JButton btnRefresh;
    private JButton btnDetail;
    private JTable table;
    private JRadioButton rdbtnAll;
    private JRadioButton rdbtnMyLeagues;
    private JRadioButton rdbtnJoinedLeagues;
    
    private DefaultTableModel leagueTableModel;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
    /**
     * Create the panel.
     */
    HomePane() {
        
        setLayout(new BorderLayout(0, 0));
        
        JPanel panelBottomControl = new JPanel();
        add(panelBottomControl, BorderLayout.SOUTH);
        panelBottomControl.setLayout(new BoxLayout(panelBottomControl, BoxLayout.X_AXIS));
        
        btnRefresh = new JButton(REFRESH);
        panelBottomControl.add(btnRefresh);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
        panelBottomControl.add(horizontalGlue_1);
        
        btnDetail = new JButton(DETAIL);
        panelBottomControl.add(btnDetail);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        panelBottomControl.add(horizontalGlue);
        
        btnJoin = new JButton(JOIN_LEAGUE);
        panelBottomControl.add(btnJoin);
        
        Component horizontalGlue_3 = Box.createHorizontalGlue();
        panelBottomControl.add(horizontalGlue_3);
        
        btnCreate = new JButton(CREATE_LEAGUE);
        panelBottomControl.add(btnCreate);
        
        JPanel panelTopControl = new JPanel();
        add(panelTopControl, BorderLayout.NORTH);
        panelTopControl.setLayout(new BoxLayout(panelTopControl, BoxLayout.X_AXIS));
        
        btnLogout = new JButton(LOGOUT);
        panelTopControl.add(btnLogout);
        
        Component horizontalGlue_2 = Box.createHorizontalGlue();
        panelTopControl.add(horizontalGlue_2);
        
        JPanel panel = new JPanel();
        panelTopControl.add(panel);
        
        rdbtnAll = new JRadioButton(RDBTN_ALL);
        buttonGroup.add(rdbtnAll);
        panel.add(rdbtnAll);
        
        rdbtnMyLeagues = new JRadioButton(RDBTN_MY_LEAGUES);
        buttonGroup.add(rdbtnMyLeagues);
        panel.add(rdbtnMyLeagues);
        
        rdbtnJoinedLeagues = new JRadioButton(RDBTN_JOINED_LEAGUES);
        buttonGroup.add(rdbtnJoinedLeagues);
        panel.add(rdbtnJoinedLeagues);
        
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        
        // --------TABLE------------------------------------------
        table = new JTable();
        table.setDragEnabled(false);
        scrollPane.setViewportView(table);
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false); // prevent dragging column
    }
    
    public void setDefaultTableModel(DefaultTableModel tableModel) {
        table.setModel(tableModel);
    }
    
    public void registerListeners(HomePaneController homePaneController) {
        btnCreate.addActionListener(homePaneController);
        btnLogout.addActionListener(homePaneController);
        btnJoin.addActionListener(homePaneController);
        btnRefresh.addActionListener(homePaneController);
        btnDetail.addActionListener(homePaneController);
    }
    
    public void registerRadioButtonListeners(LeagueTableController listener) {
        rdbtnAll.addItemListener(listener);
        rdbtnJoinedLeagues.addItemListener(listener);
        rdbtnMyLeagues.addItemListener(listener);
    }
    
    /**
     * @return league name if a league is selected<br>
     * Null if no league is selected
     */
    public String getLeagueSelected() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            return (String) table.getValueAt(selectedRow, 0);
        }
        return null;
    }
}
