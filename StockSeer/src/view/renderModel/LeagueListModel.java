package view.renderModel;

import model.LeagueModel;
import persistence.LeagueUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by anvu on 11/8/16.
 */
public class LeagueListModel extends FixedTableModel {
    private static String[] columnNames = {"Name", "Start YYYY-MM-DD", "End YYYY-MM-DD", "Capacity", "Difficulty",
            "Created By"};
    private static Vector<String> columnIdentifiers = new Vector<>();
    
    static {
        columnIdentifiers.addAll(Arrays.asList(columnNames));
    }
    
    public LeagueListModel() {
        super();
        this.setColumnIdentifiers(columnIdentifiers);
        allLeagues();
    }
    
    /**
     * Upon calling this function, LeagueUtility.getAllLeagues function will be called.<br>
     * This will update leagues reside in clients machine with newest values.
     */
    public void allLeagues() {
        ArrayList<LeagueModel> leagueModels = LeagueUtility.getAllLeagues();
        Vector<Vector<String>> tableData = new Vector<>();
        if (leagueModels != null) {
            tableData = new Vector<>();
            for (LeagueModel leagueModel : leagueModels) {
                Vector<String> row = new Vector<>();
                row.add(leagueModel.getName());
                row.add(leagueModel.getStartDate().toString());
                row.add(leagueModel.getEndDate().toString());
                row.add(leagueModel.getCapacity() + "");
                row.add(leagueModel.getDifficulty().name());
                row.add(leagueModel.getOwner());
                tableData.add(row);
            }
        }
        this.setDataVector(tableData, columnIdentifiers);
        this.fireTableDataChanged();
    }
    
    /**
     * Render league table so that only leagues owned by <b>username</b> are visible
     *
     * @param username username of the person who created leagues.
     */
    public void allLeaguesOwnedBy(String username) {
        ArrayList<LeagueModel> leagueModels = LeagueUtility.getAllLeagueOwnedBy(username);
        Vector<Vector<String>> tableData = new Vector<>();
        if (leagueModels != null) {
            for (LeagueModel leagueModel : leagueModels) {
                Vector<String> row = new Vector<>();
                row.add(leagueModel.getName());
                row.add(leagueModel.getStartDate().toString());
                row.add(leagueModel.getEndDate().toString());
                row.add(leagueModel.getCapacity() + "");
                row.add(leagueModel.getDifficulty().name());
                row.add(leagueModel.getOwner());
                tableData.add(row);
            }
        }
        this.setDataVector(tableData, columnIdentifiers);
        this.fireTableDataChanged();
    }
    
    /**
     * render the league table model so that only games that username are joined, are visible.
     *
     * @param username
     */
    public void allLeaguesJoined(String username) {
        ArrayList<LeagueModel> leagueModels = LeagueUtility.getAllLeaguesJoinedBy(username);
        Vector<Vector<String>> tableData = new Vector<>();
        if (leagueModels != null) {
            for (LeagueModel leagueModel : leagueModels) {
                Vector<String> row = new Vector<>();
                row.add(leagueModel.getName());
                row.add(leagueModel.getStartDate().toString());
                row.add(leagueModel.getEndDate().toString());
                row.add(leagueModel.getCapacity() + "");
                row.add(leagueModel.getDifficulty().name());
                row.add(leagueModel.getOwner());
                tableData.add(row);
            }
        }
        this.setDataVector(tableData, columnIdentifiers);
        this.fireTableDataChanged();
    }
}
