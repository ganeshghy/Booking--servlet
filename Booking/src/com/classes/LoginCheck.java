package com.classes;

import java.sql.*;

public class LoginCheck {
	public String check(String username, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String pwd = "root";
			
			String sql = "select uname,pwd from login where uname=? AND pwd=?";
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(query,user,pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
//		finally {
//			//Operation not allowed after ResultSet closed
//			con.close();
//			pstmt.close();
//			rs.close();
//		}

		if(rs.next()) {
			return "SUCCESS";
		}
		else {
			return "FAIL";
		}
		
		
	}
}
