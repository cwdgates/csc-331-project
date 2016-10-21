package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.UserModel;

/**
 * user data access object. Contains the logic for database operation
 * @author aqv
 *
 */
public class UserDao {
	private Connection connection;

	public UserDao() {
		connection = DatabaseConnection.getConnection();
	}

	public void addUser(UserModel user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user(first_name, last_name) values (?,?)");

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
