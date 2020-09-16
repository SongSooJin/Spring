package com.soo.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soo.web.dto.BoardDTO;
import com.soo.web.dto.LoginDTO;

@Repository
public class BoardDAO {

	//mybatis + DB 에서 만들어논 객체를 불러옴
		@Autowired
		private SqlSession sqlSession;

		public List<BoardDTO> list() throws Exception{
			return sqlSession.selectList("iot.list");
		}

		public void writeAction(BoardDTO dto) throws Exception{
			// TODO Auto-generated method stub
			
			// 매퍼에 네임스페이스.id
			sqlSession.insert("iot.writeAction", dto);
		}

		public String login(LoginDTO dto) throws Exception {
			return sqlSession.selectOne("iot.login", dto);
		}
		
		public BoardDTO detail(BoardDTO dto) throws Exception {
			return sqlSession.selectOne("iot.detail", dto);
		}
	
}
