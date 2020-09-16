package com.soo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.soo.db.DBConnection;
import com.soo.dto.BoardDTO;

public class BoardDAO {
	//데이터 접속 객체
	//데이터베이스와 일을 합니다. DBConnection, DTO->List
		
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
		
		public ArrayList<BoardDTO> boardList() {
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM boardview";
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					BoardDTO dto = new BoardDTO();
					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setLogin_name(rs.getString("login_name"));
					dto.setBoard_date(rs.getString("board_date"));
					dto.setBoard_count(rs.getInt("board_count"));
					//추가작업이 더 필요합니다.
					list.add(dto);//list에 붙여넣기
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;
		}
	}
