package model;

import java.util.ArrayList;

/**
 * list of all leagues in the current games
 * 
 * @author AnVu
 *
 */
public class LeagueListModel {
	ArrayList<LeagueModel> leagueList;

	public LeagueListModel() {
		leagueList = new ArrayList<LeagueModel>();
	}

	public void addLeague(LeagueModel league) {
		leagueList.add(league);
	}

	public void remove(LeagueModel league) {
		leagueList.remove(league);
	}

	public LeagueModel getLeague(int leagueID) {
		for (LeagueModel league : leagueList) {
			if (league.getLeagueID() == leagueID)
				return league;
		}
		return null;
	}

	/**
	 * pull data from database
	 */
	public void update() {

	}

}
