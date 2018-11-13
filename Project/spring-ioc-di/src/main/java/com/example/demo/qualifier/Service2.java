package com.example.demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Qualifier("myService")
@Order(1)
public class Service2 implements TheService{
	public void sell() {
		System.out.println("Service2");
	}
}
