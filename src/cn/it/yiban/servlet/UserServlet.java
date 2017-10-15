package cn.it.yiban.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.it.yiban.AppContext;
import cn.yiban.open.common.User;

@WebServlet("/me")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6803067242366723179L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(AppContext.ACCESS_TOKEN);
		
		User user = (User) req.getSession().getAttribute(AppContext.KEY_USER);
		String text = user.me();
		System.out.println(text);
		JSONObject json = JSON.parseObject(text);
	
		PrintWriter out = resp.getWriter();
		out.print(text);
	}

}
