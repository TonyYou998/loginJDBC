package Respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnection.MySqlConnection;

public class UserRespository {
	
	public boolean tryLogin(String username,String password) {
		try {
			Connection connection=MySqlConnection.getConnection();
			String query="SELECT * FROM user WHERE email= ? AND password=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result= statement.executeQuery();
			if(result.next())
				return true;
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
			return false;
		}
		
		return false;
	}
}
