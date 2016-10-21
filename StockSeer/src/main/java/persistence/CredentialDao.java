package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * check credential, then grant access to app
 * 
 * @author aqv
 *
 */
public class CredentialDao {
	private static Connection connection = DatabaseConnection.getConnection();

	public static boolean checkUsernamePassword(String username, String password) {
		String query = "select * from user where username = ? and password = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
