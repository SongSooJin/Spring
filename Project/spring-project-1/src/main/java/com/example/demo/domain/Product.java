package com.example.demo.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	
	private int product_id;
	private String product_name;
	private int product_price;
	private String product_image;
	private String product_detail;
/*	private int product_deliveryCharge;
	private String product_seller;
	private String product_courier;
	private String product_color;
	
	
	*/
	public int getproduct_id() {
		return product_id;
	}
	public void setproduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getproduct_name() {
		return product_name;
	}
	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getproduct_price() {
		return product_price;
	}
	public void setproduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getproduct_detail() {
		return product_detail;
	}
	public void setproduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	public String getproduct_image() {
		return product_image;
	}
	public void setproduct_image(String product_image) {
		this.product_image = product_image;
	}
	
	

//	public void Product(int productid, String productname, int price) {
//		
//		this.productid = productid;
//		this.Product_name = Product_name;
//		this.explanation = explanation;
//		this.price = price;
//	
//	}
//	
//	public int getProduct_id() {
//		
//		return productid;
//	}
//	
//	public void setProductid(int product_id) {
//		this.product_id = product_id;
//	}
//	
//	public void setProduct_name(String productname) {
//		this.Product_name = productname;
//	}
//	
//	public String getProduct_name() {
//		return Product_name;
//	}
//	
//	
//	public void setPrice(int price) {
//		this.price =  price;
//	}
//	
//	
//	public int getPrice(int price) {
//		return price;
//	}
//	

}





