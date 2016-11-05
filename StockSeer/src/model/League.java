package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import persistence.Date;

public class League {
    private String leagueName;
    private Integer leagueID;
    private int capacity;
    private Date startDate;
    private Date endDate;
    private Difficulty difficulty;

    private ArrayList<StockModel> stockList;

    public League() {
        leagueID = null;
        leagueName = null;
        capacity = 0;
        startDate = null;
        endDate = null;
        difficulty = null;
        stockList = null;
    }

    public League(Integer id, String name, int capacity, Date startDate, Date endDate, Difficulty difficulty) {
        this.leagueID = id;
        this.leagueName = name;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.difficulty = difficulty;
        stockList = null;
    }

    /**
     * @return name of the league
     */
    public String getName() {
        return leagueName;
    }

    public Integer getLeagueID() {
        return leagueID;
    }

    public int getCapacity() {
        return capacity;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public ArrayList<StockModel> getStockList() {
        return stockList;
    }

    /**
     * @return id name start_date end_date difficulty
     */
    @Override
    public String toString() {
        return "ID=" + leagueID + " NAME=" + leagueName + " START=" + startDate.toString() + " END="
                + endDate.toString() + " CAPACITY=" + capacity + " DIFFICULTY=" + difficulty.name();
    }
}
