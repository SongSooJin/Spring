package com.example.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.board.model.ProductList;


@Mapper
public interface ProductListMapper {
	public int insert(ProductList productlist);
	public int update(ProductList productlist);
	public int delete(long product_id);
	
	@Select("SELECT COUNT(*) FROM product")
	public int count();
	@Select("SELECT * FROM product ORDER BY id DESC")
	public List<ProductList> selectAll();
	
	public ProductList selectById(long product_id);
	public List<ProductList> selectByLimit(@Param("page") int page, @Param("size") int size);
	public int increment(long product_id);
}
