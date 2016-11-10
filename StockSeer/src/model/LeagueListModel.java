package model;

import persistence.LeagueUtility;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by anvu on 11/8/16.
 */
public class LeagueListModel extends DefaultTableModel {
    private static String[] columnNames = {"Name", "Start YYYY-MM-DD", "End YYYY-MM-DD", "Capacity", "Difficulty",
            "Created By"};
    private static Vector<String> columnIdentifiers  = new Vector<>();
    
    static {
        columnIdentifiers.addAll(Arrays.asList(columnNames));
    }
    
    public LeagueListModel(){
        super();
        this.setColumnIdentifiers(columnIdentifiers);
        allLeagues();
    }
    
    public void allLeagues() {
        ArrayList<League> leagues = LeagueUtility.getAllLeagues();
        Vector<Vector<String>> tableData = new Vector<>();
        if (leagues != null) {
            tableData = new Vector<>();
            for (League league : leagues) {
                Vector<String> row = new Vector<>();
                row.add(league.getName());
                row.add(league.getStartDate().toString());
                row.add(league.getEndDate().toString());
                row.add(league.getCapacity() + "");
                row.add(league.getDifficulty().name());
                row.add(league.getOwner());
                tableData.add(row);
            }
        }
        this.setDataVector(tableData, columnIdentifiers);
        this.fireTableDataChanged();
    }
    
    public void allLeaguesOwnedBy(String username){
        ArrayList<League> leagues = LeagueUtility.getAllLeagueOwnedBy(username);
        Vector<Vector<String>> tableData = new Vector<>();
        if (leagues != null) {
            tableData = new Vector<>();
            for (League league : leagues) {
                Vector<String> row = new Vector<>();
                row.add(league.getName());
                row.add(league.getStartDate().toString());
                row.add(league.getEndDate().toString());
                row.add(league.getCapacity() + "");
                row.add(league.getDifficulty().name());
                row.add(league.getOwner());
                tableData.add(row);
            }
        }
        this.setDataVector(tableData, columnIdentifiers);
        this.fireTableDataChanged();
    }
    
    public void allLeagueJoined(String username){
    	
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}

