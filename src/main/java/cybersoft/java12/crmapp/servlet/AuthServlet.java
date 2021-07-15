package cybersoft.java12.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Respository.UserRespository;
import Services.AuthService;
import cybersoft.java12.crmapp.util.JspConst;
import cybersoft.java12.crmapp.util.ServletConst;
import cybersoft.java12.crmapp.util.UrlConst;

@WebServlet(name=ServletConst.AUTH,urlPatterns ={
	UrlConst.LOGIN,
	UrlConst.FORGOT_PASSWORD,
	UrlConst.LOGOUT,
	UrlConst.SIGNUP
	
})
public class AuthServlet extends HttpServlet {
	private AuthService service;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		service=new AuthService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String path=req.getServletPath();
		
		switch(path) {
		
		case UrlConst.LOGIN:
			Cookie cookie=new Cookie("firstcookie", "this_is_the_first_cookie");//khởi tạo cookie mới tên cookie:giá trị
			cookie.setMaxAge(60);//set thời gian sống cho cookie het thoi gian click lai mat
			resp.addCookie(cookie);//add cookie
			Cookie [] cookies=req.getCookies();//lấy all cookie hiện có
			for (int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("email"))
					//nếu cooki có lưu email thì set attribute cho email qua .jsp lấy dùng lại
					req.setAttribute("email", cookies[i].getValue());
				
				
				
			}
			String status=String.valueOf(req.getSession().getAttribute("status"));
			if(status!="null") {
				resp.sendRedirect(req.getContextPath()+UrlConst.HOME);
				break;
			}
				
			req.getRequestDispatcher(JspConst.LOGIN)
			.forward(req, resp);
			
			break;
		
		case UrlConst.FORGOT_PASSWORD:
			break;
		case UrlConst.SIGNUP:
			break;
		case UrlConst.LOGOUT:
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath()+UrlConst.LOGIN);
			break;
		
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String path=req.getServletPath();
	//	UserRespository userRespo=new UserRespository();
			switch(path) {
			
			case UrlConst.LOGIN:
				String email=req.getParameter("email");
				String remember=req.getParameter("rememberLogin");
				String pass=req.getParameter("password");
				boolean isLoginSuccessfull=true;
				if(remember != null) {
					Cookie cookie=new Cookie("email", email);
					cookie.setMaxAge(60*60);
					resp.addCookie(cookie);
				}
				HttpSession currentSession=req.getSession();//lấy session
				String pingo=(String)currentSession.getAttribute("Pingo");//lấy tên và giá trị của session
				System.out.printf("Pingo %s\n",pingo);
				//logic dang nhap
				if(email==null || pass ==null)
					isLoginSuccessfull=false;
				/*else if(!userRespo.tryLogin(email, pass))
						isLoginSuccessfull=false;*/
				else if (!service.login(email, pass))
					isLoginSuccessfull=false;
				if(isLoginSuccessfull) {
					currentSession.setAttribute("status", "logged successful");
				
					resp.sendRedirect(req.getContextPath()+UrlConst.HOME);
				}
					
				else
					resp.sendRedirect(req.getContextPath()+UrlConst.LOGIN);
				
				break;
			
			
			}
	}
}
