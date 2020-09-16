package com.soo.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	// 메인 메소드
	public static void main(String[] args) { 
		Connection conn = null;
		Statement stmt = null;
		//                         //내컴퓨터:port/DB명
		//String url = "jdbc:mariadb://127.0.0.1:3306/iot";
		String url = "jdbc:mariadb://localhost:3306/test";
		String id = "soo";
		String pw = "01234567";
		String sql = "SELECT * FROM login";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("id : " + rs.getString("login_id"));
				System.out.println("name : " + rs.getString("login_name"));
				System.out.println("pw : " + rs.getString("login_pw"));
			}
			
			rs.close();
			//System.out.println("접속 성공");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			// 마지막에 사용한 것 부터 닫기 -> 역순으로 닫기
			try {
				stmt.close(); 
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
