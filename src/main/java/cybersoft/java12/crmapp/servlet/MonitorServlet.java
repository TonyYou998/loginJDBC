package cybersoft.java12.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Url;

import com.mysql.cj.MysqlConnection;

import cybersoft.java12.crmapp.util.UrlConst;
import dbconnection.MySqlConnection;
@WebServlet(name="monitorServlet",urlPatterns = {
		UrlConst.HEALTH,
		UrlConst.INVALIDATE
})
public class MonitorServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=req.getServletPath();
		switch(path) {
			case UrlConst.HEALTH:{
				//session demo
				HttpSession currentSession =req.getSession();
				
				currentSession.setAttribute("Pingo", "this is the first session att");//set tên và giá trị cho session
				currentSession.setMaxInactiveInterval(30); //tu mat sau n s
				if(MySqlConnection.getConnection() !=null) {
					resp.getWriter().append("database connection has been established");
//					System.out.println("conneccted");
				}
				
					
				else
					resp.getWriter().append("database connection could not established");
				break;
				
				}
			case UrlConst.INVALIDATE:
				req.getSession().invalidate();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + path);
				
		}
		
	}
}
