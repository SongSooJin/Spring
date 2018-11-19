package com.example.demo.domain;

public class product {
	
	int productid;
	String producttype;
	String Product_name;
	String explanation;
	int price;
	
	public int getProductid() {
		
		return productid;
	}
	
	public void Product(int productid, String producttype, String productname, String explanation, int prince, int inventroy) {
		
		this.productid = productid;
		this.producttype = producttype;
		this.Product_name = Product_name;
		this.explanation = explanation;
		this.price = price;
		this.inventory = inventroy;
	}
	
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	public String getProducttype() {
		return producttype;
	}
	
	public void setProduct_name(String productname) {
		this.Product_name = productname;
	}
	
	public String getProduct_name() {
		return Product_name;
	}
	
	
	public void setExplanation(String explnation) {
		this.explanation = explanation;
	} 
	
	public String getExplanation() {
		return explanation;
	}
	
	public void setPrice(int price) {
		this.price =  price;
	}
	
	
	public int getPrice(int price) {
		return price;
	}
	
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public int getInventory() {
		return inventory;
	}
	int inventory;
}






