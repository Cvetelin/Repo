package reporting.test.jdbc;

import java.sql.Connection;

import org.junit.rules.ExternalResource;

public class DataBaseConnectionRule extends ExternalResource{
	
	private Connection connection;

    @Override
    protected void before() throws Throwable {
	super.before();
	connection = JdbcUtils.openConnection();
    }

    @Override
    protected void after() {
	JdbcUtils.closeConnection(connection);
	super.after();
    }
    
    public Connection getConnection() {
	return connection;
    }

}
