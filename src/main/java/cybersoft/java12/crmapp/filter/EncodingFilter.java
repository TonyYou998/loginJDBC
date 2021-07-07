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
@WebFilter(urlPatterns = {UrlConst.ROOT})//bắt tất cả các url request
public class EncodingFilter implements Filter {
	private int requestCount=1;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=(HttpServletRequest) req;//ép kiểu từ servlet req sang httpservletreq
		HttpServletResponse response=(HttpServletResponse) resp;
		//xử lý req
		System.out.println("request count "+requestCount++);
		request.setCharacterEncoding("UTF-8");
		System.out.println("set charset for req");
		chain.doFilter(req, resp);
		//xứ lý resp
		resp.setCharacterEncoding("UTF-8");
		System.out.println("set charset for resp");
	}
}
