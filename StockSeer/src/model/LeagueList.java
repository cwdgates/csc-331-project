package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * list of all leagues in the current games
 *
 * @author AnVu
 */
public class LeagueList {
    ArrayList<League> leagues = null;

    public LeagueList() {
        this.leagues = new ArrayList<League>();
    }

    public LeagueList(ArrayList<League> leagues) {
        this.leagues = leagues;
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
    }

    public void addLeague(League league) {
        this.leagues.add(league);
    }

    public void remove(League league) {
        this.leagues.remove(league);
    }

    public League getLeague(int leagueID) {
        for (League league : leagues) {
            if (league.getLeagueID() == leagueID)
                return league;
        }
        return null;
    }

    public ArrayList<League> getLeagues(){
        return leagues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (League league : leagues) {
            sb.append(league.toString());
        }
        return sb.toString();
    }

}
