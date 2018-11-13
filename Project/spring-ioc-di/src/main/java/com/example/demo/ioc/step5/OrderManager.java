package com.example.demo.ioc.step5;

public class OrderManager {

	CarMaker maker;
	
//	public OrderManager() {
//		
//	}
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
	}


	public void order() {
		System.out.println("OrderManager: order() called.");
		//HyundaiMaker maker = new HyundaiMaker();;

		// 상태정보를 취급하는 클래스는 메소드내에서 만들어서 사용하고 버린다.
		Money money = new Money(2000);
		System.out.println("OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager: "+ "돈을 주고 " + car.getName() + "를 얻는다.");
	}

	
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
	
	
}
