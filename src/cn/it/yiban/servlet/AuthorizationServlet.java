package cn.it.yiban.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.it.yiban.AppContext;
import cn.yiban.open.Authorize;
import cn.yiban.open.common.User;

@WebServlet("/auth")
public class AuthorizationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 636593132245602772L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter(AppContext.KEY_CODE);
		if (code == null || code.equals("")) {
			resp.sendRedirect("/yiban_demo/index.html");
		}
		System.out.println(code);
		
		Authorize authorize = new Authorize(AppContext.APP_ID, AppContext.APP_SEC);
		String text = authorize.querytoken(code, AppContext.BACK_URL);
		
		System.out.println(text);
		JSONObject json = JSON.parseObject(text);
		AppContext.ACCESS_TOKEN = json.getString(AppContext.KEY_TOKEN);
		
		User user = new User(AppContext.ACCESS_TOKEN);
		HttpSession session = req.getSession();
		session.setAttribute(AppContext.KEY_USER, user);
		
		resp.sendRedirect("http://127.0.0.1:8080/yiban_demo/index.html");
	}
	
}
