package com.soo.web.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.soo.web.dao.BoardDAO;
import com.soo.web.dto.BoardDTO;
import com.soo.web.dto.CommentDTO;
import com.soo.web.dto.LoginDTO;
import com.soo.web.util.FileSave;

@Service
public class IotService {
	
	//Controller -> Service -> DAO -> SqlSession -> DB
		@Autowired 
		private BoardDAO boardDAO;

		@Autowired
		private FileSave fileSave;
		
		@Autowired
		private ServletContext servletContext;
		
		
		
		public List<BoardDTO> list() throws Exception{
			return boardDAO.list();
		}

		public void writeAction(BoardDTO dto, MultipartFile file) throws Exception {
			//파일저장
				//파일저장 객체 호출해서 사용
				//fileSave
				
			//실제경로
			String realPath = servletContext.getRealPath("resources/upload");
			System.out.println("실제 경로 : " + realPath );
			
			String realFileName = fileSave.save(realPath, file);
			
			//DTO에 저장 시키기
			dto.setBoard_file(realFileName);
			//DB저장
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

		public void delete(BoardDTO dto) throws Exception {
			boardDAO.delete(dto);
		}

		public BoardDTO update(BoardDTO dto) throws Exception {
			return boardDAO.update(dto);
		}
		
		public void updateAction(BoardDTO dto) throws Exception {
			boardDAO.updateAction(dto);
		}
		
		public int comment(CommentDTO dto) {
			return boardDAO.comment(dto);
		}

		public List<CommentDTO> commentList(int board_no) {
			return boardDAO.commentList(board_no);
		}
		
		public void commentDelete(CommentDTO dto) {
			boardDAO.commentDelete(dto);	
		}

		public CommentDTO commentEdit(CommentDTO edit) {
			return boardDAO.commentEdit(edit);
		}

		public int commentEditAction(CommentDTO dto) {
			return boardDAO.commentEditAction(dto);
		}

		public int checkID(String id) {
			return boardDAO.checkID(id);
		}

		public void joinAction(LoginDTO dto) {
			boardDAO.joinAction(dto);		
		}
}
