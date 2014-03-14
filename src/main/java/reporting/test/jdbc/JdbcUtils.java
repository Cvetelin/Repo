package reporting.test.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcUtils {
	
	private static  String hsqlDriver;
	private static  String dbUrl;
	private static  String dbUsername;
	private static  String dbPassword;
	
	static{
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("test-context.properties");
			prop.load(input);
			hsqlDriver = prop.getProperty("HSQLDB_DRIVER");
			dbUrl= prop.getProperty("DB_URL");
			dbUsername = prop.getProperty("DB_USERNAME");
			dbPassword = prop.getProperty("DB_PASSWORD");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static Connection openConnection() throws Exception {
		Class.forName(hsqlDriver);
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static String selectSingle(Connection connection, String sql) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				return resultSet.getString(1);
			}
			return null;
		} finally {
			if(resultSet != null) {
				resultSet.close();
			}
			statement.close();
		}
	}
	
	public static List<String> selectColumn(Connection connection, String sql, String columnLabel) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(sql);
			List<String> results = new ArrayList<String>();
			while (resultSet.next()) {
				results.add(resultSet.getString(columnLabel));
			}
			return results;
		} finally {
			if(resultSet != null) {
				resultSet.close();
			}
			statement.close();
		}
	}
}
