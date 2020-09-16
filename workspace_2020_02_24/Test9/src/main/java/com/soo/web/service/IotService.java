package com.soo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soo.web.dao.BoardDAO;
import com.soo.web.dto.BoardDTO;
import com.soo.web.dto.LoginDTO;

@Service
public class IotService {
	
	//Controller -> Service -> DAO -> SqlSession -> DB
		@Autowired 
		private BoardDAO boardDAO;
		
		public List<BoardDTO> list() throws Exception{
			return boardDAO.list();
		}

		public void writeAction(BoardDTO dto) throws Exception {
			
			boardDAO.writeAction(dto);
		}
		//void = update, insert, delete
		//반환타입 있는것 = select

		public String login(LoginDTO dto) throws Exception {
			return boardDAO.login(dto);
		}
		
		public BoardDTO detail(BoardDTO dto) throws Exception {
			return boardDAO.detail(dto);
		}

}
