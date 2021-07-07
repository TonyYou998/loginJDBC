package cybersoft.java12.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.crmapp.util.UrlConst;

@WebServlet(name = "homeServlet", urlPatterns = {
		"/home", "/home/level2"
		})
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String path=req.getServletPath();
		
		switch(path) {
		case UrlConst.HOME:
			req.getRequestDispatcher("/WEB-INF/views/home/homepage.jsp")
			.forward(req, resp);
			break;
		
			
		
		}
		
	}
}
