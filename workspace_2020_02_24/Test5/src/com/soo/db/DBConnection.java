package com.soo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public Connection getConnection() {
		// 접속정보 넣어주기
		Connection conn = null;
		
		//class, url, id, pw
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "soo", "guddk717"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn; // 리턴으로 접속객체 conn반환
	}
}
