package cybersoft.java12.crmapp.servlet;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import Dto.UserCreateDto;
import Modal.User;
import Services.UserServices;
import cybersoft.java12.crmapp.util.JspConst;
import cybersoft.java12.crmapp.util.UrlConst;
import dao.UserDao;
@WebServlet(name="userServlet",urlPatterns = {
		UrlConst.USER_DASHBOARD,
		UrlConst.USER_PROFILE,
		UrlConst.USER_ADD,
		UrlConst.USER_UPDATE,
		UrlConst.USER_DELETE
		
})
public class UserServlet extends HttpServlet {
	private UserServices userSerVice;
	private UserDao userDao;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		userSerVice=new UserServices();
		userDao=new UserDao();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(req.getServletPath()) {
			case UrlConst.USER_DASHBOARD:
				getUserDashboard(req,resp);
				break;
			case UrlConst.USER_PROFILE:
				getUserProfile(req, resp);
				break;
			case UrlConst.USER_ADD:
				getUserAdd(req,resp);
				
				break;
			
			
		}
	}
	private void getUserAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(req.getServletPath()) {
		case UrlConst.USER_DASHBOARD:
		
			break;
		case UrlConst.USER_PROFILE:
			
			break;
		case UrlConst.USER_ADD:
			getUserAdd(req,resp);
			break;
		
		
	}
	}
	private void doPostUserAdd(HttpServletRequest req, HttpServletResponse resp) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String phone=req.getParameter("phone");
		String name =req.getParameter("name");
		String address=req.getParameter("address");
		int roleId=Integer.parseInt(req.getParameter("roleId")) ;
		
		//UserCreateDto dto=new UserCreateDto();
		
	}

	private void getUserProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void getUserDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <User> users=userSerVice.findAll();
		if(users!=null && !users.isEmpty())
			req.setAttribute("users", users);
		req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
	}
}
