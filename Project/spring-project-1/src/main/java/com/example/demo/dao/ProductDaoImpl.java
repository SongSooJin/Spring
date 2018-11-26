package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Product;

/*
 * 개발자가 @Mapper 애노테이션을 사용하는 대신 직접 인터페이스를 
 * 구현한 클래스를 작성하면 매퍼 XML에게 전달하는 파라미터 값을 
 * 조작할 수 있는 메소드 공간을 가질 수 있다. 
 * 더불어서 질의 결과를 조작할 수 있는 로직도 배치할 수 있다.
 */
@Repository
public class ProductDaoImpl implements ProductDao {
	/*
	 * SqlSessionTemplate 객체를 주입 받는다.
	 * 스프링 부트는 마이바티스 디펜던시를 선택하는 것만으로 
	 * 빈 컨테이너에 해당 객체가 등록되지만
	 * 스프링 레가시에서는 개발자가 직접 등록해야 한다.
	 */
	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(Product product) {
		return session.insert(
				"com.example.demo.dao.ProductDao.insert", product);
	}

	@Override
	public int update(Product product) {
		return session.update(
				"com.example.demo.dao.ProductDao.update", product);
	}

	@Override
	public int delete(int product_id) {
		return session.delete(
				"com.example.demo.dao.ProductDao.delete", product_id);
	}

	@Override
	public List<Product> findAll() {
		return session.selectList(
				"com.example.demo.dao.ProductDao.findAll");
	}

	@Override
	public int count() {
		return session.selectOne(
				"com.example.demo.dao.ProductDao.count");
	}

	@Override
	public Product findOne(int product_id) {
		return session.selectOne(
				"com.example.demo.dao.ProductDao.findOne", product_id);
	}

	@Override
	public List<Product> findByPageSizeUsingBind(int page, int size) {
		Map<String, Integer> map = new HashMap<>();
        map.put("page", page); // 페이지(몇 번째 화면)
        map.put("size", size); // 개수
        
		return session.selectList(
			"com.example.demo.dao.ProductDao.findByPageSizeUsingBind", map);
	}
	
	@Override
	public List<Product> search(Map<String, String> map) {
		/*
		 * 매퍼 XML의 <if> 태그에서 제대로 된 값의 상태를 체크하기 위한 처리작업이 필요하다.
		 * 1. 빈 문자열을 null로 바꾼다. if 조건에서 null 값으로 비교할 수 있다.
		 * 2. if 조건에서 null 값으로 비교하는 대신 빈 문자열을 대상으로 체크한다.
		 */
		
		// #1 방식으로 사용하기 위한 처리작업을 수행한다.
		map.forEach((key, value) -> {
			if ("".equals(value)) {
				map.put(key, null);
			}
		});
		
		return session.selectList(
				"com.example.demo.dao.ProductDao.search", map);
	}

	@Override
	public List<Product> productlist(Map<String, String> map) {
		map.forEach((key, value) -> {
			if ("".equals(value)) {
				map.put(key, null);
			}
		});
		
		return session.selectList(
				"com.example.demo.dao.ProductDao.productlist", map);
	}

}