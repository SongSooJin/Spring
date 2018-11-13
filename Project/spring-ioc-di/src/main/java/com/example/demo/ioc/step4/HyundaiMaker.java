package com.example.demo.ioc.step4;

public class HyundaiMaker implements CarMaker {
	
	@Override //부모 또는 CarMaker가 정의해놓은것을 재정의 하는것 
	public Car sell (Money money)  {
		System.out.println("HyundaiMaker: sell(Money money) called.");
		
		
		System.out.println("HyundaiMaker: " + money.getAmount() + "원을 차 값으로 받는다.");
		
		Car car = new Car("Sonata");
		System.out.println("HyundaiMaker: " + car.getName() + "을 만들어 판다.");
		
		return car;
	}
}
