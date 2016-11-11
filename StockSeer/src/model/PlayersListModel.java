package model;

import java.util.Vector;

public class PlayersListModel extends FixedTableModel {
	private static Vector<String> columnIdentifier = new Vector<>();
	
	static{
		columnIdentifier.add("Player");
	}
	
	public PlayersListModel(){
		super();
		this.setColumnIdentifiers(columnIdentifier);
		allPlayers();
	}
	
	public void allPlayers(){
		Vector<Vector<String>> players = new Vector<>();
		Vector<String> row = new Vector<>();
		
		players.add(row);
		this.setDataVector(players, columnIdentifiers);
		this.fireTableDataChanged();
	}
}
