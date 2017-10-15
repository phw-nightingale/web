package cn.it.yiban.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.it.yiban.db.BaseDb;
import cn.it.yiban.moudel.TransInfo;

@WebServlet("/trans")
public class TranscenterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7782229665849876240L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String name = req.getParameter("name");
			Integer sex = Integer.valueOf(req.getParameter("sex"));
			String nature = req.getParameter("nature");
			String home_place = req.getParameter("home_place");
			
			String birthdayStr = req.getParameter("birthday");
			Date birthdayD = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
			Long birthday = birthdayD.getTime();
			
			String schooldayStr = req.getParameter("schoolday");
			Date schooldayD = new SimpleDateFormat("yyyy-MM-dd").parse(schooldayStr);
			Long schoolday  = schooldayD.getTime();
			
			String department = req.getParameter("department");
			String clazz = req.getParameter("class");
			Integer xuezhi = Integer.valueOf(req.getParameter("xuezhi"));
			String stuid = req.getParameter("stuid");
			String phone = req.getParameter("phone");
			String addr = req.getParameter("addr");
			String train = req.getParameter("train");
			String reason = req.getParameter("reason");
			TransInfo transInfo = new TransInfo(name, sex, nature, home_place, birthday, schoolday, department, clazz,
					xuezhi, stuid, phone, addr, train, reason);
			BaseDb db = new BaseDb();
			db.save(transInfo);
			String json = "{'status':'success', 'message':'操作成功！'}";
			PrintWriter out = resp.getWriter();
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
