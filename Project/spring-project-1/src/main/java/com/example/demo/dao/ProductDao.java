package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.Product;

public interface ProductDao {
	public int insert(Product product);
	public int update(Product product);
	public int delete(int product_name);
	
	public List<Product> findAll();
	public int count();
	public Product findOne(int product_name);
	


	public List<Product> findByPageSizeUsingBind(int page, int size);
	
	
	public List<Product> search(Map<String, String> map);
	
}



