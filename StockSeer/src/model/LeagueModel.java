package model;

import java.util.Date;

public class LeagueModel {
	private String leagueName;
	private String leagueID;
	private int maxPlayers;
	private Date startDate;
	private Date endDate;

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(String leagueID) {
		this.leagueID = leagueID;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
