package persistence;

import model.Difficulty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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
    public static Vector<Vector<String>> getStocksForLeague(Difficulty diff, int num) {
        num = num + 2;
        PreparedStatement statement;
        try {
            String sql = "SELECT symbol, name FROM sp500\n" +
                    "ORDER BY RAND()\n" +
                    "LIMIT ?;";
            
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, num);
            ResultSet rs = statement.executeQuery();
            Vector<Vector<String>> stocks = new Vector<>();
            while (rs.next()) {
                Vector<String>temp = new Vector<>();
                temp.add(rs.getString("symbol"));
                temp.add(rs.getString("name"));
                stocks.add(temp);
            }
            return stocks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
