package com.example.demo.ioc.step6;

import org.springframework.stereotype.Component;

//<bean id ="KiaMaker" class="com.example.demo.ioc.step6.KiaMaker"> 와 아래 component 값이 같다.
// id를 생략하면 클래스명을 id로 사용한다. 단, id는 소문자로 시작
@Component("KiaMaker")
public class KiaMaker implements CarMaker {
	
	@Override
	public Car sell (Money money) {
		System.out.println("KiaMaker: sell(Money money) called.");
		
		
		System.out.println("KiaMaker: " + money.getAmount() + "원을 차 값으로 받는다.");
		
		Car car = new Car("K7");
		System.out.println("KiaMaker: " + car.getName() + "을 만들어 판다.");
		
		return car;
	}
}
