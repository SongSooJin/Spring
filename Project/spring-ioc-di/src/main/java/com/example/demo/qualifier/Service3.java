package com.example.demo.qualifier;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Service3 implements TheService{
	public void sell() {
		System.out.println("Service3");
	}
}
