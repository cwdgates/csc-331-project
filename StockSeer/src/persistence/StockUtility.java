package persistence;

import model.Difficulty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by anvu on 11/22/16.
 * Accessing sp500 table
 */
public class StockUtility {
    
    /**
     * get stocks for the league <br>
     * status: WORKING
     *
     * @param diff difficulty
     * @param num  number of players
     * @return stocks
     */
    public static String[] getStocksForLeague(Difficulty diff, int num) {
        num = num + 2;
        PreparedStatement statement;
        try {
//            String sql = "SELECT symbol FROM sp500 AS r1 JOIN (SELECT CEIL(RAND() * (SELECT MAX(id) FROM sp500)) AS "
//                    + "id) AS r2 WHERE r1.id >= r2.id ORDER BY r1.id ASC LIMIT ?;";
            
            String sql = "SELECT symbol FROM sp500\n" +
                    "ORDER BY RAND()\n" +
                    "LIMIT ?;";
            
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, num);
            ResultSet rs = statement.executeQuery();
            ArrayList<String> stocks = new ArrayList<>();
            while (rs.next()) {
                stocks.add(rs.getString("symbol"));
            }
            return stocks.toArray(new String[stocks.size()]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
