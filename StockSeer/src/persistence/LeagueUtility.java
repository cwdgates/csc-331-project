package persistence;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Date;
import model.Difficulty;
import model.LeagueModel;

public abstract class LeagueUtility {
    
    /**
     * check whether or not the database has this league
     *
     * @param leagueName
     * @return true if database has this league, false otherwise
     */
    public static boolean hasLeague(String leagueName) {
        PreparedStatement selectSTMT = null;
        try {
            String sql = "SELECT id FROM leagues WHERE name = ?";
            selectSTMT = DBConnection.getConnection().prepareStatement(sql);
            selectSTMT.setString(1, leagueName);
            ResultSet rs = selectSTMT.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selectSTMT != null)
                    selectSTMT.close();
            } catch (SQLException e) {
                System.err.println("Can't close statement");
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static boolean createLeague(String name, int capacity, Date startDate, Date endDate, Difficulty
            difficulty, String owner) {
        PreparedStatement insertSTMT = null;
        try {
            String sql = "INSERT INTO leagues " + " (name, start_date, end_date, capacity, difficulty, owner) "
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
                System.err.println("Can't insert a leagues to the database");
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
    public static LeagueModel getLeagueFromDB(String leagueName) {
        LeagueModel leagueModel = null;
        PreparedStatement selectSTMT;
        ResultSet rs;
        try {
            String sql = "SELECT * FROM leagueModel WHERE name = ?";
            selectSTMT = DBConnection.getConnection().prepareStatement(sql);
            selectSTMT.setString(1, leagueName);
            rs = selectSTMT.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String owner = rs.getString("owner");
                leagueModel = new LeagueModel(name, capacity, startDate, endDate, difficulty, owner);
            }
        } catch (SQLException e) {
            System.err.println("Can't get leagueModel.");
            e.printStackTrace();
            return null;
        }
        return leagueModel;
    }
    
    /**
     * get all league objects
     *
     * @return ArrayList contains all league objects
     */
    public static ArrayList<LeagueModel> getAllLeagues() {
        PreparedStatement selectSTMT = null;
        ResultSet rs;
        ArrayList<LeagueModel> leagueModels;
        
        try {
            String sql = "SELECT id, name, capacity, start_date, end_date, difficulty, owner FROM leagues ORDER BY " +
                    "name ASC";
            selectSTMT = DBConnection.getConnection().prepareStatement(sql);
            rs = selectSTMT.executeQuery();
            leagueModels = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String owner = rs.getString("owner");
                LeagueModel leagueModel = new LeagueModel(name, capacity, startDate, endDate, difficulty, owner);
                leagueModels.add(leagueModel);
            }
            
        } catch (SQLException e) {
            System.err.println("Can't get all leagueModels from DB");
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
        
        return leagueModels;
    }
    
    /**
     * @param owner the league owner
     * @return all leagues owned by owner, ordered by name ascending
     */
    public static ArrayList<LeagueModel> getAllLeagueOwnedBy(String owner) {
        ArrayList<LeagueModel> leagueModels = null;
        PreparedStatement statement = null;
        
        try {
            String sql = "SELECT name, capacity, start_date, end_date, difficulty, owner FROM leagues WHERE owner " +
                    "= ? ORDER BY name ASC";
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, owner);
            ResultSet rs = statement.executeQuery();
            leagueModels = new ArrayList<>();
            
            while (rs.next()) {
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String league_owner = rs.getString("owner");
                LeagueModel leagueModel = new LeagueModel(name, capacity, startDate, endDate, difficulty, league_owner);
                leagueModels.add(leagueModel);
            }
            
        } catch (SQLException e) {
            System.err.println("Can't get all leagueModels owned by ...");
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
        
        return leagueModels;
        
    }
    
    /**
     * @param username the client's username
     * @return leagues that username joins
     */
    public static ArrayList<LeagueModel> getAllLeaguesJoinedBy(String username) {
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM leagues WHERE name IN (SELECT league_name FROM user_league WHERE username = ?)";
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            
            ArrayList<LeagueModel> leagueModels = new ArrayList<>();
            
            while (rs.next()) {
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                Date startDate = new Date(rs.getString("start_date"));
                Date endDate = new Date(rs.getString("end_date"));
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                String league_owner = rs.getString("owner");
                LeagueModel leagueModel = new LeagueModel(name, capacity, startDate, endDate, difficulty, league_owner);
                leagueModels.add(leagueModel);
            }
            
            return leagueModels;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e1) {
                System.err.println("ERROR::Can't close statement");
            }
        }
        return null;
    }
    
    /**
     * @param leagueName
     * @param stocks     stocks symbol
     * @return
     */
    public static boolean assignStocks(String leagueName, String[] stocks) {
        if (hasLeague(leagueName)) {
            PreparedStatement statement = null;
            StringBuilder sql = new StringBuilder("INSERT INTO stock_league (league_name, symbol) VALUES\n");
            
            for (int i = 0; i < stocks.length; i++) {
                sql.append("((SELECT name FROM leagues WHERE name = ?), (SELECT symbol from sp500 WHERE symbol = ?))");
                if (i != stocks.length - 1) {
                    sql.append(",\n");
                } else {
                    sql.append(";");
                }
            }
            
            System.out.println(sql.toString());
            
            try {
                statement = DBConnection.getConnection().prepareStatement(sql.toString());
                for (int i = 0; i < stocks.length; i++) {
                    statement.setString(i * 2 + 1, leagueName);
                    statement.setString(i * 2 + 2, stocks[i]);
                }
                statement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.err.println("ERROR: Can't assign stocks");
                e.printStackTrace();
                return false;
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        System.err.println("ERROR::can't close statement");
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.err.println("WARNING::This league does not exists");
            return false;
        }
    }
}
