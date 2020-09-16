package com.soo.db;

import java.sql.Connection;
import java.sql.DriverManager;

//싱글톤 패턴으로 만들어 보기 (static)
public class DBConn {
	//객체 생성
	private static DBConn dbConn = new DBConn();
	
	//객체를 반환할 메소드
	public static DBConn getInstance() {
		return dbConn;
	}
	
	//DB접속 connection
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "soo", "guddk717"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
