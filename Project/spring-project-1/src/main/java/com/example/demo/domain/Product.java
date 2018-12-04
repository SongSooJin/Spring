package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


import lombok.Data;

@Data
@PropertySource(value = {"my.properties"})
public class Product {
	
	private int product_id;
	private String product_name;
	private int product_price;
	private String product_image;
	private String product_detail;
	private String product_deliveryCharge;
	private int hit_count;
	
	
	@Value("${image.location}")
	private String image_location;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	public String getProduct_deliveryCharge() {
		return product_deliveryCharge;
	}

	public void setProduct_deliveryCharge(String product_deliveryCharge) {
		this.product_deliveryCharge = product_deliveryCharge;
	}

	public String getImage_location() {
		return image_location;
	}

	public void setImage_location(String image_location) {
		this.image_location = image_location;
	}

	
	
	
	
	

}





