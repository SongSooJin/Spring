package com.example.demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Qualifier("myService")
@Order(2)
public class Service1 implements TheService{
	@Override
	public void sell() {
		
	}
	
	public void sell2() {}
}
