package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ProductDao;
import com.example.demo.domain.Product;

@Controller
@RequestMapping("/products")
public class ProductController<Vo> {
	private static final Class<Product> product_name = null;
	@Autowired
	private ProductDao productDao;
	private Product product;

	@GetMapping
	public String getSearchView() {
		return "search";
	}

	@PostMapping
	public Object postOne(@RequestParam HashMap<String, String> map, Model model) {

		// 브라우저는 검색화면에서 사용자가 직업란의 검색어를 입력하지 않아도
		// job="" 형태로 파라미터를 전달한다.
		// 빈 문자열은 null이 아니므로 주의가 필요하다.
		System.out.println(map);
		// 예: {ename=길동, job=, salMin=, salMax=}

		List<Product> products = productDao.search(map);
		model.addAttribute("products", products);

		System.out.println(map);
		// 예: {ename=길동, job=null, salMin=null, salMax=null}

		model.addAttribute("conditions", searchConditionToHtml(map));
		// model.addAttribute("conditions1", searchConditionToHtml1(map));

		return "search";
	}

	private String searchConditionToHtml(HashMap<String, String> map) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("검색조건: ");
		
		for(Object o : map.keySet()) { 
			if(map.get(o).equals(map)) { 
				return ("<mark> "+ "'" + map.get("product_name") +"'" + "에 대한  검색결과가 없습니다."+"</mark> ");
				}
			else {
			return ("<mark> "+ "'" + map.get("product_name") +"'" + "에 대한 "+ productDao.count()+"건 검색결과</mark> ");
			} 
		}
		return ("<mark>ALL</mark>");

		
		
//		if (map.get("product_name").equals("product_name")) {
//			sb.append("<mark> "+ "'" + map.get("product_name") +"'" + "에 대한 "+ productDao.count()+"건 검색결과</mark> ");	
//		} else {
//			sb.append("<mark> "+ "'" + map.get("product_name") +"'" + "에 대한  검색결과가 없습니다."+"</mark> ");
//		}
//		
//		if (map.get("product_name") != map.get("product_name")) {
//			sb.append("<mark> "+ "'" + map.get("product_name") +"'" + "에 대한  검색결과가 없습니다."+"</mark> ");
//		}
		
//		if ("검색조건: ".equals(sb.toString())) {
//			sb.append("<mark>ALL</mark>");
//		}
//		
			
		
//		return sb.toString();
	}

}
