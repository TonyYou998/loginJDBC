package Services;

import java.util.List;

import Modal.User;

import dao.UserDao;

public class UserServices {

	
	
	
	private UserDao dao;
	public  UserServices() {
		dao=new UserDao();
	}
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users=null;
		try {
			users=dao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	
		return users;
	}
	
}
