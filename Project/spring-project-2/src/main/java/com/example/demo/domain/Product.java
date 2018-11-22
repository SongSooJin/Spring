package com.example.demo.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	
	private int product_id;
	private String product_name;
	private int product_price;
/*	private int product_deliveryCharge;
	private String product_seller;
	private String product_courier;
	private String product_color;
	*/

	
	
/*	
	public void Product(int productid, String productname, int price) {
		
		this.productid = productid;
		this.Product_name = Product_name;
		this.explanation = explanation;
		this.price = price;
	
	}
	
	public int getProductid() {
		
		return productid;
	}
	
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	public void setProduct_name(String productname) {
		this.Product_name = productname;
	}
	
	public String getProduct_name() {
		return Product_name;
	}
	
	
	public void setPrice(int price) {
		this.price =  price;
	}
	
	
	public int getPrice(int price) {
		return price;
	}*/
	

}





