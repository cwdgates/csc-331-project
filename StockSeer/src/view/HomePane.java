package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.table.DefaultTableModel;

import controller.HomePaneController;
import controller.LeagueTableController;

import java.awt.Dimension;

public class HomePane extends JPanel {

	/**
	 * create NonEditableTableModel class in order to disable ability to edit
	 * leagues data using GUI at Home Pane
	 */

	public static final String BTN_CREATE_LEAGUE = "Create a league";
	public static final String BTN_JOIN_LEAGUE = "Join";
	public static final String BTN_LOGOUT = "Logout";
	public static final String BTN_REFRESH = "Refresh";
	public static final String BTN_DETAIL = "Detail";
	public static final String RDBTN_ALL = "All";
	public static final String RDBTN_MY_LEAGUES = "My leagues";
	public static final String RDBTN_JOINED_LEAGUES = "Joined leagues";
	public static final String ALL_PLAYERS = "All Players";
	private JButton btnCreate;
	private JButton btnLogout;
	private JButton btnJoin;
	private JButton btnRefresh;
	private JButton btnDetail;
	private JTable leagueTable;
	private JRadioButton rdbtnAll;
	private JRadioButton rdbtnMyLeagues;
	private JRadioButton rdbtnJoinedLeagues;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnAllPlayers;
	private JSplitPane splitPane;
	private JScrollPane playerScrollPane;
	private JTable playerTable;
	private Component horizontalGlue_2;
	private Component horizontalStrut;

	/**
	 * Create the panel.
	 */
	HomePane() {
		setMinimumSize(new Dimension(600, 500));

		setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(splitPane, BorderLayout.CENTER);

		JScrollPane leagueScrollPane = new JScrollPane();
		splitPane.setLeftComponent(leagueScrollPane);

		// --------TABLE------------------------------------------
		leagueTable = new JTable();
		leagueTable.setDragEnabled(false);
		leagueScrollPane.setViewportView(leagueTable);

		leagueTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// prevent dragging column
		leagueTable.getTableHeader().setReorderingAllowed(false);

		playerScrollPane = new JScrollPane();
		playerScrollPane.setMinimumSize(new Dimension(80, 23));
		playerScrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		playerScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		splitPane.setRightComponent(playerScrollPane);

		// -------------Players table
		playerTable = new JTable();
		playerTable.getTableHeader().setReorderingAllowed(false);
		playerScrollPane.setViewportView(playerTable);

		JPanel panelBottomControl = new JPanel();
		add(panelBottomControl, BorderLayout.SOUTH);
		panelBottomControl.setLayout(new BoxLayout(panelBottomControl, BoxLayout.X_AXIS));

		btnRefresh = new JButton(BTN_REFRESH);
		panelBottomControl.add(btnRefresh);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panelBottomControl.add(horizontalGlue_1);

		btnDetail = new JButton(BTN_DETAIL);
		panelBottomControl.add(btnDetail);

		Component horizontalGlue = Box.createHorizontalGlue();
		panelBottomControl.add(horizontalGlue);

		btnJoin = new JButton(BTN_JOIN_LEAGUE);
		panelBottomControl.add(btnJoin);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panelBottomControl.add(horizontalGlue_3);

		btnCreate = new JButton(BTN_CREATE_LEAGUE);
		panelBottomControl.add(btnCreate);

		JPanel panelTopControl = new JPanel();
		add(panelTopControl, BorderLayout.NORTH);
		panelTopControl.setLayout(new BoxLayout(panelTopControl, BoxLayout.X_AXIS));

		btnLogout = new JButton(BTN_LOGOUT);
		panelTopControl.add(btnLogout);

		JPanel panel = new JPanel();
		panelTopControl.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);

		rdbtnAll = new JRadioButton(RDBTN_ALL);
		rdbtnAll.setSelected(true);
		buttonGroup.add(rdbtnAll);
		panel.add(rdbtnAll);

		rdbtnMyLeagues = new JRadioButton(RDBTN_MY_LEAGUES);
		buttonGroup.add(rdbtnMyLeagues);
		panel.add(rdbtnMyLeagues);

		rdbtnJoinedLeagues = new JRadioButton(RDBTN_JOINED_LEAGUES);
		buttonGroup.add(rdbtnJoinedLeagues);
		panel.add(rdbtnJoinedLeagues);

		horizontalGlue_2 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_2);

		btnAllPlayers = new JButton(ALL_PLAYERS);
		panel.add(btnAllPlayers);

		splitPane.setResizeWeight(0.85);

	}

	public void setLeagueTableModel(DefaultTableModel tableModel) {
		leagueTable.setModel(tableModel);
	}

	public void setPlayersListTableModel(DefaultTableModel tableModel) {
		playerTable.setModel(tableModel);
	}

	public void registerListeners(HomePaneController homePaneController) {
		btnCreate.addActionListener(homePaneController);
		btnLogout.addActionListener(homePaneController);
		btnJoin.addActionListener(homePaneController);
		btnRefresh.addActionListener(homePaneController);
		btnDetail.addActionListener(homePaneController);
		btnAllPlayers.addActionListener(homePaneController);
	}

	public void registerRadioButtonListeners(LeagueTableController listener) {
		rdbtnAll.addItemListener(listener);
		rdbtnJoinedLeagues.addItemListener(listener);
		rdbtnMyLeagues.addItemListener(listener);
	}

	/**
	 * @return league name if a league is selected<br>
	 *         Null if no league is selected
	 */
	public String getLeagueSelected() {
		int selectedRow = leagueTable.getSelectedRow();
		if (selectedRow >= 0) {
			return (String) leagueTable.getValueAt(selectedRow, 0);
		}
		return null;
	}
}
