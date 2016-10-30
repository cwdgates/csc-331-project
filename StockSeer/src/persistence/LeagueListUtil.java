package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Difficulty;
import model.League;

public abstract class LeagueListUtil {
	public static ArrayList<League> getAllLeagues() {
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<League> leagues = null;

		try {
			String sql = "SELECT * FROM league";
			statement = DBConnection.getConnection().prepareStatement(sql);
			rs = statement.executeQuery();
			leagues = new ArrayList<League>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int capacity = rs.getInt("capacity");
				Date startDate = new Date(rs.getString("start_date"));
				Date endDate = new Date(rs.getString("end_date"));
				Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
				League league = new League(id, name, capacity, startDate, endDate, difficulty);
				System.out.println(league.toString());
				leagues.add(league);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return leagues;
	}
}
