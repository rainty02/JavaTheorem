package ncs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connetor {
	
	public static Connection getConnector() throws SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String id = "bit";
		String pw = "bit";
		
		return DriverManager.getConnection(jdbcUrl, id, pw);	
	}
}
