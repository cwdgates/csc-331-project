package persistence;

/**
 * provide table name
 * @author anvu
 *
 */
public abstract class DBInfo {
	public static final String USER_TBL = "user";
	public static final String LEAGUE_TBL = "league";
	
	public class User{
		public static final String USERNAME_COL = "username";
	}
}
