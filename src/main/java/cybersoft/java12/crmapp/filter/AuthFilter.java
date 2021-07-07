package cybersoft.java12.crmapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.crmapp.util.UrlConst;
@WebFilter(urlPatterns = UrlConst.ROOT)
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;//ép kiểu từ servlet req sang httpservletreq
		HttpServletResponse response=(HttpServletResponse) resp;
		String path=request.getServletPath();//lấy cái sau/ vd /login
		if(path.startsWith(UrlConst.ASSETS) || path.startsWith(UrlConst.LOGIN)||path.startsWith(UrlConst.HEALTH))
			chain.doFilter(request, response);//cho qua
		else { 
			String status=String.valueOf(request.getSession().getAttribute("status"));//lấy stattus từ session kiểm tra dc nếu bị null
			System.out.println(status);
			if (status=="null")
				response.sendRedirect(request.getContextPath()+UrlConst.LOGIN);//lấy cái trước / vd appcrm/
			else {
				chain.doFilter(request, response);
			}
			}
		
		
	}
}
