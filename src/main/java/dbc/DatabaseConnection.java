package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	// �������ݿ���������
	private static final String DBDRIVER = "com.mysql.jc.jdbc.Driver";
	// ���ݿ����ӵ�ַ
	private static final String DBURL = "jdbc:mysql://localhost:3306/rms";// rms��ʾ���ݿ�
	private static final String DBUSER = "root";
	private static final String DBPASS = "123456";
	private Connection connection = null;

	public DatabaseConnection() throws Exception {
		try {
			// ���ݿ�������ܳ����쳣
			Class.forName(DBDRIVER);
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

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