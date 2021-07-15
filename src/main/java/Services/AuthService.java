package Services;

import java.sql.SQLException;

import dao.AuthDao;

public class AuthService {
	private AuthDao dao;
	public AuthService() {
		dao=new AuthDao();
		
	}
	public boolean login(String email,String password) {
		try {
			int result=dao.login( email, password);
			return result>0;
		}
		catch(SQLException e	) {
			e.printStackTrace();
			return false;
		}
		
	}
}
