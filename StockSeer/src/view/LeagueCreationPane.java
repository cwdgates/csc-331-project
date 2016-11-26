package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ChooseStockController;
import controller.LeagueCreationController;
import model.Difficulty;
import model.Date;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class LeagueCreationPane extends JPanel {
    public final static String BTN_CANCEL = "Cancel";
    public final static String BTN_CREATE = "Create";
    public final static String BTN_CHOOSE_STOCK = "Choose stocks...";
    
    private JTextField txtLeagueName;
    private JButton btnCancel;
    private JButton btnCreate;
    private JButton btnChooseStocks;
    private JComboBox<Integer> comboBoxCapacity;
    private DatePickerPane startDatePicker;
    private DatePickerPane endDatePicker;
    
    private final ButtonGroup btnGrpDifficulty = new ButtonGroup();
    private JRadioButton rdbtnEasy;
    private JRadioButton rdbtnMedium;
    private JRadioButton rdbtnHard;
    private Component horizontalStrut;
    
    private String[] stocks;
    private JScrollPane scrollPane;
    private JTextPane textPaneStocks;
    
    /**
     * Create the panel.
     */
    public LeagueCreationPane() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{50, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JPanel panelForm = new JPanel();
        GridBagConstraints gbc_panelForm = new GridBagConstraints();
        gbc_panelForm.anchor = GridBagConstraints.NORTH;
        gbc_panelForm.insets = new Insets(0, 0, 5, 0);
        gbc_panelForm.fill = GridBagConstraints.HORIZONTAL;
        gbc_panelForm.gridx = 0;
        gbc_panelForm.gridy = 0;
        add(panelForm, gbc_panelForm);
        GridBagLayout gbl_panelForm = new GridBagLayout();
        gbl_panelForm.columnWidths = new int[]{115, 327, 0};
        gbl_panelForm.rowHeights = new int[]{26, 27, 27, 27, 0, 0};
        gbl_panelForm.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panelForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelForm.setLayout(gbl_panelForm);
        
        JLabel lblLeagueName = new JLabel("LeagueModel Name");
        GridBagConstraints gbc_lblLeagueName = new GridBagConstraints();
        gbc_lblLeagueName.anchor = GridBagConstraints.EAST;
        gbc_lblLeagueName.insets = new Insets(0, 0, 5, 5);
        gbc_lblLeagueName.gridx = 0;
        gbc_lblLeagueName.gridy = 0;
        panelForm.add(lblLeagueName, gbc_lblLeagueName);
        
        txtLeagueName = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.anchor = GridBagConstraints.NORTH;
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        panelForm.add(txtLeagueName, gbc_textField);
        txtLeagueName.setColumns(10);
        
        JLabel lblNumberOfPlayers = new JLabel("Number of Players");
        GridBagConstraints gbc_lblNumberOfPlayers = new GridBagConstraints();
        gbc_lblNumberOfPlayers.anchor = GridBagConstraints.EAST;
        gbc_lblNumberOfPlayers.insets = new Insets(0, 0, 5, 5);
        gbc_lblNumberOfPlayers.gridx = 0;
        gbc_lblNumberOfPlayers.gridy = 1;
        panelForm.add(lblNumberOfPlayers, gbc_lblNumberOfPlayers);
        
        comboBoxCapacity = new JComboBox<>();
        GridBagConstraints gbc_comboBoxCapacity = new GridBagConstraints();
        gbc_comboBoxCapacity.anchor = GridBagConstraints.NORTH;
        gbc_comboBoxCapacity.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCapacity.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxCapacity.gridx = 1;
        gbc_comboBoxCapacity.gridy = 1;
        panelForm.add(comboBoxCapacity, gbc_comboBoxCapacity);
        
        JLabel lblStartDate = new JLabel("Start Date");
        GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
        gbc_lblStartDate.anchor = GridBagConstraints.EAST;
        gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblStartDate.gridx = 0;
        gbc_lblStartDate.gridy = 2;
        panelForm.add(lblStartDate, gbc_lblStartDate);
        
        startDatePicker = new DatePickerPane();
        GridBagConstraints gbc_startDatePicker = new GridBagConstraints();
        gbc_startDatePicker.fill = GridBagConstraints.BOTH;
        gbc_startDatePicker.insets = new Insets(0, 0, 5, 0);
        gbc_startDatePicker.gridx = 1;
        gbc_startDatePicker.gridy = 2;
        panelForm.add(startDatePicker, gbc_startDatePicker);
        
        JLabel lblEndDate = new JLabel("End Date");
        GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
        gbc_lblEndDate.anchor = GridBagConstraints.EAST;
        gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblEndDate.gridx = 0;
        gbc_lblEndDate.gridy = 3;
        panelForm.add(lblEndDate, gbc_lblEndDate);
        
        endDatePicker = new DatePickerPane();
        GridBagConstraints gbc_endDatePicker = new GridBagConstraints();
        gbc_endDatePicker.insets = new Insets(0, 0, 5, 0);
        gbc_endDatePicker.anchor = GridBagConstraints.NORTH;
        gbc_endDatePicker.fill = GridBagConstraints.HORIZONTAL;
        gbc_endDatePicker.gridx = 1;
        gbc_endDatePicker.gridy = 3;
        panelForm.add(endDatePicker, gbc_endDatePicker);
        
        JPanel panelDifficulty = new JPanel();
        GridBagConstraints gbc_panelDifficulty = new GridBagConstraints();
        gbc_panelDifficulty.fill = GridBagConstraints.BOTH;
        gbc_panelDifficulty.gridx = 1;
        gbc_panelDifficulty.gridy = 4;
        panelForm.add(panelDifficulty, gbc_panelDifficulty);
        
        rdbtnEasy = new JRadioButton("Easy");
        rdbtnEasy.setSelected(true);
        btnGrpDifficulty.add(rdbtnEasy);
        panelDifficulty.add(rdbtnEasy);
        
        rdbtnMedium = new JRadioButton("Medium");
        btnGrpDifficulty.add(rdbtnMedium);
        panelDifficulty.add(rdbtnMedium);
        
        rdbtnHard = new JRadioButton("Hard");
        btnGrpDifficulty.add(rdbtnHard);
        panelDifficulty.add(rdbtnHard);
        for (int i = 2; i <= 10; i++) {
            comboBoxCapacity.addItem(i);
        }
        
        scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        add(scrollPane, gbc_scrollPane);
        
        textPaneStocks = new JTextPane();
        textPaneStocks.setEditable(false);
        scrollPane.setViewportView(textPaneStocks);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        add(panel, gbc_panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        btnCancel = new JButton("Cancel");
        panel.add(btnCancel);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        panel.add(horizontalGlue);
        
        btnChooseStocks = new JButton(BTN_CHOOSE_STOCK);
        panel.add(btnChooseStocks);
        
        horizontalStrut = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut);
        
        btnCreate = new JButton("Create");
        btnCreate.setEnabled(false);
        panel.add(btnCreate);
        
    }
    
    /**
     * @return null if date is invalid <br>
     * GregorianCalendar object if date is valid
     */
    public Date getStartDate() {
        return startDatePicker.getDate();
    }
    
    /**
     * @return null if date is invalid <br>
     * GregorianCalendar object if date is valid
     */
    public Date getEndDate() {
        return endDatePicker.getDate();
    }
    
    /**
     * @return Name of the league.<br>
     * Whitespace at beginning and end will be trimmed<br>
     * Case sensitive
     */
    public String getLeagueName() {
        return txtLeagueName.getText().trim();
    }
    
    public int getCapacity() {
        return (int) comboBoxCapacity.getSelectedItem();
    }
    
    /**
     * get difficulty level that the user choose
     *
     * @return Difficulty object
     */
    public Difficulty getDifficulty() {
        if (rdbtnEasy.isSelected())
            return Difficulty.EASY;
        if (rdbtnMedium.isSelected())
            return Difficulty.MEDIUM;
        if (rdbtnHard.isSelected())
            return Difficulty.HARD;
        return Difficulty.EASY;
    }
    
    /**
     * set all fields to initial values (blanks)
     */
    public void resetFields() {
        txtLeagueName.setText("");
        comboBoxCapacity.setSelectedIndex(0);
        rdbtnEasy.setSelected(true);
        startDatePicker.reset();
        endDatePicker.reset();
    }
    
    /**
     * @param controller LeagueCreationController
     */
    public void registerListeners(LeagueCreationController controller) {
        btnCancel.addActionListener(controller);
        btnCreate.addActionListener(controller);
        btnChooseStocks.addActionListener(controller);
    }
    
    public void registerListeners(ChooseStockController controller) {
        btnChooseStocks.addActionListener(controller);
    }
    
    public void setStocks(String[] stocks) {
        this.stocks = stocks;
    }
    
    public String[] getStocks() {
        return stocks;
    }
    
    public void setBtnCreateEnabled(boolean isEnable) {
        btnCreate.setEnabled(isEnable);
    }
}
