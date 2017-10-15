package cn.it.yiban.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.it.yiban.AppContext;
import cn.yiban.open.Authorize;


public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		final String IGNOR_URL = "/index.jsp";
		
		HttpServletRequest req = (HttpServletRequest)request;  
        HttpServletResponse res = (HttpServletResponse) response;  
		String url = req.getRequestURL().toString();
		
		if (url.contains(IGNOR_URL)) {
			chain.doFilter(req, res);
		} else {
	        //如果没有登录
	        if (req.getSession().getAttribute("user") == null) {
	        	Authorize authorize = new Authorize(AppContext.APP_ID, AppContext.APP_SEC);
	        	String s = authorize.forwardurl(AppContext.BACK_URL, "QUERY", Authorize.DISPLAY_TAG_T.WEB);
	        	res.sendRedirect(s);
	        }
		}
        chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
