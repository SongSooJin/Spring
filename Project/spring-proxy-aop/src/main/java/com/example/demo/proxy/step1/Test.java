package com.example.demo.proxy.step1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // Client
	@Autowired
	private Hello hello;
	
	public void order() {
		// 매일매일 다른 로직을 수행해야 한다면 코드의 변경을 불가피합니다.
		// 이는 매우 나쁘다. 코드 수정이 필요한 클래스는 영원히 개발이 종료되지 않게 됩니다.
		//hello.say();
		((HelloImpl)hello).say2();
	}
	
	/*
	 * Client가 Service가 가져야 할 로직을 갖고 있으면 SRP 원칙에 위반됩니다.
	 * 그래서 줄 긋는 로직을 서비스 역할의 객체로 옮겼습니다.
	 * 그랬더니 항상 같은 로직을 제공하게 됩니다.
	 * -클라이언트는 Hello~!!!만 출력하거나
	 * -앞뒤로 줄을 그으면서 Hello~!!!를 출력하고 싶습니다.
	 * 어떻게 해결할까요?
	 * 
	 * SRP : 단일 책임 원칙 (Single responsibility principle)
	 * 한 클래스는 하나의 책임만 가져야 한다.
	 * (ex-자동차 : 바퀴는 바퀴 역할만, 엔진은 엔진 역할만 할 수 있도록 해야한다.)
	 */

	public static void main(String[] args) {
		Hello hello = new HelloImpl(); // Service 객체(Client로부터 요청을 받음)
		
		hello.say();
		
		System.out.println();
		
//		System.out.println("------------");
		hello.say();
//		System.out.println("============");
		
		System.out.println();
		
		//(HelloImpl) : 다운캐스팅
		((HelloImpl)hello).say2();
	}
}
