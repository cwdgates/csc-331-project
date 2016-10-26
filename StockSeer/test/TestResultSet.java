import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import persistence.DBConnection;

public class TestResultSet {

	public static void main(String[] args) {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO user (username, email, password) VALUES (?,?,?)";
			preparedStatement = DBConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, "anvu03");
			preparedStatement.setString(2, "anvu0301@gmail.com");
			preparedStatement.setString(3, "123");
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				preparedStatement.close(); // this will close rs as well
				System.out.println("statement status=" + (preparedStatement.isClosed() == true ? "closed" : "open"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
