package com.example.demo.ioc.step6;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * 축구에서 공격수, 수비수, 골기퍼로 나누듯이
 * 웹 프로그램을 컨트롤러, 서비스, 라파지스토리로 나누어 관리한다.
 * 이는 역할에 따라서 구분하면 관리성이 중대되기 때문인데
 * 클래스를 빈 컨테이너에 등록할 때, 역할에 따라 @Component를 상속한
 * @Service 애노테이션을 대신 사용하는 이유가 된다.
 * */


@Service("manager") // manager이름으로 객체를 만든다 
public class OrderManager {

	// 빈 컨테이너에서 자료형이 CarMaker인 객체를 직접 변수에 할당한다.
	@Autowired // 컨테이너에 있는거 찾아서 해줘
	@Qualifier("KiaMaker") // KiaMaker이걸로 
	CarMaker maker;
	
	public OrderManager() {
		
	}
	
	/*
	 * expected single matching bean but found 2: HyundaiMaker,KiaMaker
	 * 
	 */
	
	public OrderManager(@Qualifier("KiaMaker")CarMaker maker) {
		super();
		this.maker = maker;
	}


	public void order() {
		System.out.println("OrderManager: order() called.");
		
		// 상태정보를 취급하는 클래스는 메소드내에서 만들어서 사용하고 버린다.
		Money money = new Money(2000);
		System.out.println("OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager: "+ "돈을 주고 " + car.getName() + "를 얻는다.");
	}
	
	

	public CarMaker getMaker() {
		return maker;
	}


	// 빈 컨테이너에서 id가 HyundaiMaker인 객체를 파라미터로 주입하라.
	@Resource(name="HyundaiMaker")
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
	
	
}
