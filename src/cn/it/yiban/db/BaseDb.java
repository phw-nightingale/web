package cn.it.yiban.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import cn.it.yiban.moudel.TransInfo;

public class BaseDb {

	private static final String driverClassName = "com.mysql.jdbc.Driver";
	
	private static final String url = "jdbc:mysql://112.74.35.116:3306/transcenter?characterEncoding=utf-8";
	
	private static final String username = "root";
	
	private static final String password = "199798";
	
	private static Connection conn;
	
	private static java.sql.PreparedStatement pstmt;
	
	private static ResultSet rs;
	
	private Connection getConnention() throws SQLException, ClassNotFoundException {
		
		Class.forName(driverClassName);
		
		Connection conn = (Connection) DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	
	private void close() throws SQLException {
		
		if (conn != null) {
			conn.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
	}
	
	public void save(TransInfo info) throws ClassNotFoundException, SQLException {
		
		conn = getConnention();
		String sql = "insert into trans_info values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, info.getName());
		pstmt.setObject(2, info.getSex());
		pstmt.setObject(3, info.getNature());
		pstmt.setObject(4, info.getHome_place());
		pstmt.setObject(5, info.getBirthday());
		pstmt.setObject(6, info.getSchoolday());
		pstmt.setObject(7, info.getDepartment());
		pstmt.setObject(8, info.getClazz());
		pstmt.setObject(9, info.getXuezhi());
		pstmt.setObject(10, info.getStuid());
		pstmt.setObject(11, info.getPhone()	);
		pstmt.setObject(12, info.getAddr());
		pstmt.setObject(13, info.getTrain());
		pstmt.setObject(14, info.getReason());
		pstmt.execute();
		close();
	}
	
}
