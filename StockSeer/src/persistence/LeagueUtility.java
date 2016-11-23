package persistence;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import model.Difficulty;
import model.League;

public abstract class LeagueUtility {
    
    public static boolean isLeagueNameUnique(String leagueName) {
        PreparedStatement selectSTMT = null;
        try {
            String sql = "SELECT id FROM league WHERE name = ?";
            selectSTMT = DBConnection.getConnection().prepareStatement(sql);
            selectSTMT.setString(1, leagueName);
            ResultSet rs = selectSTMT.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // operation failed
        } finally {
            try {
                if (selectSTMT != null)
                    selectSTMT.close();
            } catch (SQLException e) {
                System.err.println("Can't close statement");
                e.printStackTrace();
            }
        }
        return true;
    }
    
    public static boolean createLeague(String name, int capacity, Date startDate, Date endDate, Difficulty
            difficulty, String owner) {
        PreparedStatement insertSTMT = null;
        try {
            String sql = "INSERT INTO league " + " (name, start_date, end_date, capacity, difficulty, owner) "
                    + " VALUES (?,?,?,?,?,?)";
            insertSTMT = DBConnection.getConnection().prepareStatement(sql);
            insertSTMT.setString(1, name);
            insertSTMT.setString(2, startDate.toString());
            insertSTMT.setString(3, endDate.toString());
            insertSTMT.setInt(4, capacity);
            insertSTMT.setString(5, difficulty.toString());
            insertSTMT.setString(6, owner);
            
            int numAffectedRow = insertSTMT.executeUpdate();
            if (numAffectedRow == 0) {
                System.err.println("Can't insert a league to the database");
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Can't insert.");
            e.printStackTrace();
        } finally {
            try {
                if (insertSTMT != null)
                    insertSTMT.close();
            } catch (SQLException e) {
                System.err.println("Can't close statement.");
                e.printStackTrace();
            }
        }
        return false;
    }
    
    /**
     * get league from the database
     *
     * @param leagueName Name of the league
     * @return LeagueModel object
     */
    public static League getLeagueFromDB(String leagueName) {
        League league = null;
        PreparedStatement selectSTMT = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM league WHERE name = ?";
            selectSTMT = DBConnection.getConnection().prepareStatement(sql);
            selectSTMT.setString(1, leagueName);
            rs = selectSTMT.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String owner = rs.getString("owner");
                league = new League(id, name, capacity, startDate, endDate, difficulty, owner);
            }
        } catch (SQLException e) {
            System.err.println("Can't get league.");
            e.printStackTrace();
            return null;
        }
        return league;
    }
    
    /**
     * get all league objects
     *
     * @return ArrayList contains all league objects
     */
    public static ArrayList<League> getAllLeagues() {
        PreparedStatement selectSTMT = null;
        ResultSet rs = null;
        ArrayList<League> leagues = null;
        
        try {
            String sql = "SELECT id, name, capacity, start_date, end_date, difficulty, owner FROM league ORDER BY " +
                    "name ASC";
            selectSTMT = DBConnection.getConnection().prepareStatement(sql);
            rs = selectSTMT.executeQuery();
            leagues = new ArrayList<League>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String owner = rs.getString("owner");
                League league = new League(id, name, capacity, startDate, endDate, difficulty, owner);
                leagues.add(league);
            }
            
        } catch (SQLException e) {
            System.err.println("Can't get all leagues from DB");
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (selectSTMT != null)
                    selectSTMT.close();
            } catch (SQLException e) {
                System.err.println("Can't close SELECT statement.");
                e.printStackTrace();
            }
        }
        
        return leagues;
    }
    
    /**
     * @param owner
     * @return all leagues owned by owner, ordered by name ascending
     */
    public static ArrayList<League> getAllLeagueOwnedBy(String owner) {
        ArrayList<League> leagues = null;
        PreparedStatement statement = null;
        
        try {
            String sql = "SELECT id, name, capacity, start_date, end_date, difficulty, owner FROM league WHERE owner " +
                    "= ? ORDER BY name ASC";
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, owner);
            ResultSet rs = statement.executeQuery();
            leagues = new ArrayList<>();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String league_owner = rs.getString("owner");
                League league = new League(id, name, capacity, startDate, endDate, difficulty, league_owner);
                leagues.add(league);
            }
            
        } catch (SQLException e) {
            System.err.println("Can't get all leagues owned by ...");
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Can't close statement.");
                e.printStackTrace();
            }
        }
        
        return leagues;
        
    }
    
    public static ArrayList<League> getAllLeaguesJoinedBy(String username) {
        ArrayList<League> leagues = null;
        PreparedStatement statement = null;
        
        try {
            String sql = ""; // FIXME still need to have sql query here
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            leagues = new ArrayList<>();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String owner = rs.getString("owner");
                League league = new League(id, name, capacity, startDate, endDate, difficulty, owner);
                leagues.add(league);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return leagues;
    }
}
