package com.classes;

import java.sql.*;

public class AddBookDao {
	public String insertRecord(int bno,String bname,String author, String lan,float price) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			String query = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String pwd = "root";
			
			String sql = "insert into booking values(?,?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(query,user,pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, bname);
			pstmt.setString(3, author);
			pstmt.setString(4, lan);
			pstmt.setFloat(5, price);
			
			i = pstmt.executeUpdate();
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i > 0) {
			return "SUCCESS";
		}
		else {
			return "FAIL";
		}
		
	}
}
