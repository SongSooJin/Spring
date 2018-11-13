package com.example.demo.ioc.step2;

public class KiaMaker  {
	
	
	public Car sell (Money money) {
		System.out.println("KiaMaker: sell(Money money) called.");
		
		
		System.out.println("KiaMaker: " + money.getAmount() + "원을 차 값으로 받는다.");
		
		Car car = new Car("K7");
		System.out.println("KiaMaker: " + car.getName() + "을 만들어 판다.");
		
		return car;
	}
}
