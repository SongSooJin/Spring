package com.example.demo.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProductDao;
import com.example.demo.domain.Product;



@Controller
@RequestMapping("/products")
//@PropertySource(value = {"my.properties"})
public class ProductController<Vo> {
	
	@Autowired
	private ProductDao productDao;
	private Product product;
	
	@ModelAttribute("active")
	public String active(){
		return "product";
	}
	
	/*@Value("${image.location}")
	private String image_location;*/
	
	@GetMapping
	public String getProductlistView() {
		return "product";
	}
	
	
	@PostMapping
	public String postOne(@RequestParam String product_name , Model model) {
		System.out.println(product_name);
		
		List<Product> result = productDao.findAll(product_name);
		model.addAttribute("result",result);


		return "product";
	}
	
	
	@GetMapping("/view/{product_id}")
	public ModelAndView getBoardView(@PathVariable int product_id) {
		productDao.increment(product_id);
		ModelAndView mav = new ModelAndView("productlist2");
		mav.addObject("product", productDao.selectById(product_id));
		return mav;
	}
	

//	private String searchConditionToHtml(Map<String, String> map) {
//		
//		if (map.get("product_name") != null) {
//			
//		}
//		return ("<mark> "+"'"+map.get("product_name")+"'"+"의 검색 결과"+"</mark> ");
//
//	
//	}

}
