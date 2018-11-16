package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Emp;


@Repository
public class EmpDaoImpl implements EmpDao {

	// SqlSession
	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(Emp emp) {
	
		return 0;
	}

	@Override
	public int update(Emp emp) {
		
		return 0;
	}

	@Override
	public int delete(int empno) {
		
		return 0;
	}

	@Override
	public List<Emp> findAll() {
		
		return session.selectList("com.example.demo.dao.EmpDao.findAll");
	}

	@Override
	public int count() {
		
		return 0;
	}

	@Override
	public Emp findOne(int empno) {
		
		return null;
	}
	
	//---------------------------------------------------------------------------------------

	@Override
	public List<Emp> findStartEnd(int start, int end) {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		return session.selectList("com.example.demo.dao.EmpDao.findStartEnd", map);
		
	}

	@Override
	public List<Emp> findSkipLimit(int skip, int limit) {
		Map<String, Integer> map = new HashMap<>();
		map.put("skip", skip);
		map.put("limit", limit);
		
		return session.selectList("com.example.demo.dao.EmpDao.findSkipLimit", map);
	}

	@Override
	public List<Emp> findPageSize(int page, int size) {
		// page로 받아서 skip으로 바꿔치기 
		int skip = 0;
		if (page > 0) {
			skip = (page -1) * size;
		}
		
		Map<String, Integer> map = new HashMap<>();
		map.put("skip", skip);
		map.put("limit", size); // 개수
		
		return session.selectList("com.example.demo.dao.EmpDao.findPageSize", map);
	}

	// bind 사용 예제 
	@Override
	public List<Emp> findPageSizeUsingBind(int page, int size) {
		Map<String, Integer> map = new HashMap<>();
		map.put("page", page);
		map.put("size", size); // 개수
		
		return session.selectList("com.example.demo.dao.EmpDao.findPageSizeUsingBind", map);
	}
	
	@Override
	public List<Emp> search(Map<String, String> map) {
		return session.selectList("com.example.demo.dao.EmpDao.search", map);
	}

	

}
