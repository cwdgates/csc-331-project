import java.sql.*;

public class ConnectMySQL {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success load driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
		final String URL = "jdbc:mysql://east-mysql-stock-seer.cqyb2iutlbre.us-east-1.rds.amazonaws.com:3306/stock_seer_0";
		final String USER = "anvu03";
		final String PASS = "Hoangyen59";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();
			String sql;
			sql = "Select username, first_name, last_name from user";
			ResultSet rs = stmt.executeQuery(sql);

			// get query result
			System.out.println("Print result of the query...");
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("first_name"));
				System.out.println(rs.getString("last_name"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
