package com.example.demo.ioc.step2;

public class Test {
	// 왜? 프레임 워크를 사용하는가.
	// 차 안타고 걸어다녀도 된다.
	// 스프링은 100개 이상의 라이브러리 집합체이다.
	// 왜? Inversion of Control 개념을 적용해야 하는가?
	
	// IOC는 객체를 관리하는 주체가 역전됨을 의미한다.
	// 개발자 ==> 프레임 워크 
	// 개발자 객체를 직접 관리하지 않고 프레임워크가 대신 객체를 관리한다.
	
	public static void main(String[] args) {
		OrderManager manager = new OrderManager();
		
		manager.order();
	}
}
