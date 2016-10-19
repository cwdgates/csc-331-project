
/**
 * @#resources http://thejavatrail.blogspot.com/2012/08/step-by-step-guide-developing-mvc.html
 */

package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class handle the database connection to our MySQL server. We read
 * ".properties" file which contains the information necessary for the
 * connection.
 * 
 * @author aqv
 *
 */
public class DbUtil {
	private static Connection connection = null;

	/**
	 * @return Connection to the database
	 */
	@SuppressWarnings("finally")
	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}

		try {
			Properties prop = new Properties();
			InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(inputStream);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("username");
			String password = prop.getProperty("password");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);

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
}
