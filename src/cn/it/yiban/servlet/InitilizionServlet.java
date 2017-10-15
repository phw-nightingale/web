package cn.it.yiban.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.it.yiban.AppContext;
import cn.yiban.open.Authorize;

@WebServlet("/init")
public class InitilizionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4634124722565801643L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Authorize authorize = new Authorize(AppContext.APP_ID, AppContext.APP_SEC);
		String url = authorize.forwardurl(AppContext.BACK_URL, "QUERY", Authorize.DISPLAY_TAG_T.MOBILE);
		
		res.sendRedirect(url);
	}

}
