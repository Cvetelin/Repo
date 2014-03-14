package db.test;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Test;

import reporting.test.jdbc.JdbcUtils;



public class DataBaseConnectionTest {


	private Connection connection;

	@Test
	public void testConnection(){
		try{
			connection=JdbcUtils.openConnection();
			JdbcUtils.closeConnection(connection);
		}catch(Exception e){
			fail("Unable to establish or close DB connection");
			e.printStackTrace();
		}
		
	}
}
