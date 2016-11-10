package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://115.159.225.105:3306/rms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DBUSER = "root";
	private static final String DBPASS = "123456";
	private Connection connection = null;

	public DatabaseConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			connection = (Connection)DriverManager.getConnection(DBURL, DBUSER, DBPASS);

		} catch (Exception exception) {
			throw exception;
		} finally {}
	}

	public Connection getConnection() {
		return connection;
	}

	public void close() throws Exception {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				throw e;
			}
		}

	}

}