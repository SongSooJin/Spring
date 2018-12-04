package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Product;

@Mapper
public interface ProductDao {
	public int insert(Product product);
	public int update(Product product);
	public int delete(int product_name);
	
	public List<Product> findAll(String product_name);
	public int count();
	public Product findOne(int product_name);

	public List<Product> findByPageSizeUsingBind(int page, int size);
	
	public List<Product> productlist(Map<String, String> map);
	
	public Product selectById(int product_id);
	public int increment(int product_id);
	
}



