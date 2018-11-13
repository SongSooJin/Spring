package com.example.demo.ioc.step4;

public class OrderManager {
	// 비즈니스 환경에서 사용하는 프로그램은 변화의 요구가 극심하다.
	// 현대자동차에게 주문하던 것을 기아자동차로 변경해야 하는 요구가 발생
	// HyundaiMaker maker = new HyundaiMaker();
	// KiaMaker maker = new KiaMaker();
	
	
	// 1. 인터페이스 도입 효과 : 멤버변수 부분은 변경이 필요없게 되었다.
	CarMaker maker;
	
//	public OrderManager() {
		
//		maker = new HyundaiMaker();
//		maker = new KiaMaker();
		
//	}
	
	
	// 고객의 요구는 다양하다. 어떤 고객은 매일매일 거래 자동차 회사를 바꾸고 싶어 한다.
	// 개발자인 우리는 어떻게 해야할까 
	// 변화를 적용할 때 코드의 수정을 가하는 것은 매우 나쁜 방법이다.
	// 변화를 외부로 분리하고 사용자가 직접 변화를 적용 할 수 있도록 조치해야 한다.
	
	// OrderManager의 거래처가 변화하더라도 OrderManager 클래스내에 코드 변경을 막는 방법
	// 1. 인터페이스 도입 
	// 2. 객체관리를 클래스내에서 직접하지 않는다.
	
	
	public void order() {
		System.out.println("OrderManager: order() called.");
		
		// 상태정보를 취급하는 클래스는 메소드내에서 만들어서 사용하고 버린다.
		Money money = new Money(2000);
		System.out.println("OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager: "+ "돈을 주고 " + car.getName() + "를 얻는다.");
	}

	// 1. 인터페이스 도입 효과 : CarMaker 구현체는 모든지 받을수 있다.
	public void setMaker(CarMaker maker) {
		// 2. 객체관리를 클래스내에서 직접하지 않는다.
		// OM가 사용하는 객체를 스스로 생성하지 않고 외부에서 주는대로 받아서 사용한다.
		this.maker = maker;
	}
	
	
}
