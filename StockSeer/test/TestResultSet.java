import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.DBConnection;

public class TestResultSet {

	public static void main(String[] args) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT * FROM user";
			preparedStatement = DBConnection.getConnection().prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			preparedStatement.close(); // this will close rs as well
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		try {
			System.out.println(preparedStatement.isClosed());
			System.out.println(resultSet.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
