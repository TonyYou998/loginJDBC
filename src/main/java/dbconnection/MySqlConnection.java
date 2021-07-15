package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static Connection connection;
	private static final String URL="jdbc:mysql://localhost:3306/crm";//ten db
	private static final String USERNAME="root";
	private static final String PASSWORD="1234";
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(connection==null ||connection.isClosed())
				connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			return connection;
		}
		catch(ClassNotFoundException e) {
			System.out.println("driver not found");
			
		}
		catch(SQLException ex) {
			System.out.println("database connection could not establish");
			
		}
		return null;
	}
}
