package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.Pager;
import com.example.board.repository.ProductListMapper;

@Controller
@RequestMapping("/productlists")
public class ProductListController {
	@Autowired
	private ProductListMapper productListMapper;
	
	@ModelAttribute("active")
	public String active(){
		return "product";
	}
	
	@GetMapping()
	public ModelAndView getBoardsView(
			@RequestParam(name="page", required=false, defaultValue="1") int page,
			@RequestParam(name="size", required=false, defaultValue="10") int size,
			@RequestParam(name="bsize", required=false, defaultValue="5") int bsize) {
		ModelAndView mav = new ModelAndView("product_list");
		// 게시글 데이터
		mav.addObject("productlists", productListMapper.selectByLimit(page, size));
		// 페이징 처리와 관련된 데이터
		mav.addObject("pager", new Pager(page, size, bsize, productListMapper.count()));
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView getBoardView(@PathVariable long product_id) {
		productListMapper.increment(product_id);
		ModelAndView mav = new ModelAndView("productlist_view");
		mav.addObject("productlist", productListMapper.selectById(product_id));
		return mav;
	}
	
}
