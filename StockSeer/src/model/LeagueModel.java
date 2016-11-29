package model;

import java.util.GregorianCalendar;

public class LeagueModel {
    private String name;
    private int capacity;
    private Date startDate;
    private Date endDate;
    private Difficulty difficulty;
    private String owner;
    
    public LeagueModel() {
        name = null;
        capacity = 0;
        startDate = null;
        endDate = null;
        difficulty = null;
    }
    
    /**
     * @param name
     * @param capacity
     * @param startDate
     * @param endDate
     * @param difficulty
     * @param owner      who creates the league
     */
    public LeagueModel(String name, int capacity, Date startDate, Date endDate, Difficulty difficulty, String
            owner) {
        this.name = name;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.difficulty = difficulty;
        this.owner = owner;
    }
    
    /**
     * @return name of the league
     */
    public String getName() {
        return name;
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
    
    /**
     * @return name of the league
     */
    @Override
    public String toString() {
        return name;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        return this.name.equals(((LeagueModel) obj).getName());
    }
}
