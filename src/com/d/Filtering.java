package com.d;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filtering implements Filter{
private ServletContext context;
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) resp;
		HttpSession ses=request.getSession();
		System.out.println(ses.getAttribute("uname"));
		if(ses.getAttribute("uname")==null)
			response.sendRedirect("login?error=session_expired");
		else
			chain.doFilter(req, resp);
		
	}
public void init(FilterConfig config)
{
	this.context=config.getServletContext();

}

public void destroy()
{}
}
