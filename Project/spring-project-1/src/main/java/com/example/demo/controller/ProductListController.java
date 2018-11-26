package com.example.demo.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ProductDao;
import com.example.demo.domain.Product;



@Controller
@RequestMapping("/productlists")
//@PropertySource(value = {"my.properties"})
public class ProductListController<Vo> {
	
	@Autowired
	private ProductDao productDao;
	private Product product;
	
	
	/*@Value("${image.location}")
	private String image_location;*/
	
	@GetMapping
	public String getProductlistView() {
		return "productlist";
	}
	
	@PostMapping
	public String postOne(@RequestParam Map<String, String> map, Model model) {
		System.out.println(map);
		
		List<Product> productsd = productDao.productlist(map);
		model.addAttribute("products", productsd);
		
		System.out.println(map);
		// 예: 

		model.addAttribute("conditions", searchConditionToHtml(map));


		return "productlist";
	}
	

	private String searchConditionToHtml(Map<String, String> map) {
		
		if (map.get("product_name") != null) {
			
		}
		return ("<mark> "+"'"+map.get("product_name")+""+"의 검색 결과"+"</mark> ");

		
		
		

	
	}
	
//	@ModelAttribute("active")
//	public String active(){
//		return "product";
//	}
//	
//	@GetMapping()
//	public ModelAndView getBoardsView(
//			@RequestParam(name="page", required=false, defaultValue="1") int page,
//			@RequestParam(name="size", required=false, defaultValue="10") int size,
//			@RequestParam(name="bsize", required=false, defaultValue="5") int bsize) {
//		ModelAndView mav = new ModelAndView("product_list");
//		// 게시글 데이터
//		mav.addObject("productlists", productListMapper.selectByLimit(page, size));
//		// 페이징 처리와 관련된 데이터
//		mav.addObject("pager", new Pager(page, size, bsize, productListMapper.count()));
//		return mav;
//	}
//	
//	@GetMapping("/view/{id}")
//	public ModelAndView getBoardView(@PathVariable long product_id) {
//		productListMapper.increment(product_id);
//		ModelAndView mav = new ModelAndView("productlist_view");
//		mav.addObject("productlist", productListMapper.selectById(product_id));
//		return mav;
//	}
//	
}
