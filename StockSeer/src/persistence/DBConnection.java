
/**
 * @#resources http://thejavatrail.blogspot.com/2012/08/step-by-step-guide-developing-mvc.html
 */

package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

/**
 * This class handle the database connection to our MySQL server. We read
 * ".properties" file which contains the information necessary for the
 * connection.
 *
 * @author aqv
 */
public abstract class DBConnection {
    private static Connection connection = null;
    
    /**
     * @return shared Connection object (only one Connection object is needed
     * for this app since it connect to only one database server (AWS
     * RDS)
     */
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        
        try {
            Properties prop = new Properties();
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(inputStream);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("username");
            String password = prop.getProperty("password");
            Class.forName(driver);
            System.out.println("Trying to connect to the database...");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connect to the database.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // e.printStackTrace();
            System.err.println("Can't connect to the database.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Database Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
