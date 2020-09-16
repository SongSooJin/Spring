package com.soo.dao;
import com.soo.db.DBConn;
import com.soo.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO2 {
	
	//LOGIN
		public String login(String id, String pw) {
			String name = "";
			DBConn dbConn = DBConn.getInstance();
			Connection conn = dbConn.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT login_name FROM login WHERE login_id = ? AND login_pw = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					name = rs.getString(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		return name;
		
	}
	
	
	public BoardDTO detail(int board_no){
		//DB접속정보
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		//Connection conn = DBConn.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM boardview WHERE board_no = ?";
		BoardDTO dto = new BoardDTO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			//DB로 board_no정보 보내기
			pstmt.setInt(1, board_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setBoard_no(rs.getInt(1));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_content(rs.getString(3));
				dto.setLogin_name(rs.getString("login_name"));
				dto.setBoard_date(rs.getString(5));
				dto.setBoard_count(rs.getInt("board_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//값받기
		return dto;
	}

	public ArrayList<BoardDTO> list(){
		//DB접속
		DBConn dbConn = DBConn.getInstance();//객체 만들기? -> 객체 불러오기
		Connection conn = dbConn.getConnection();//접속 정보 받기
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM boardview";
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt(1));
				dto.setBoard_title(rs.getString(2));
				dto.setLogin_name(rs.getString(4));
				dto.setBoard_date(rs.getString(5));
				dto.setBoard_count(rs.getInt(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return list;
	}
}

