package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DummyConnectionProvider {

	public static Connection getConnection() throws SQLException{
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone";
		String user = "bi";
		String pw = "bit";
		
		return DriverManager.getConnection(jdbcUrl, user, pw);
	}
}
