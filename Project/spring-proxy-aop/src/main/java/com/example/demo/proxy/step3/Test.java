package com.example.demo.proxy.step3;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // Client
	
	public static void main(String[] args) {
		Hello hello = new HelloImpl(); // Service 객체(Client로부터 요청을 받음)
		
		hello.say();
		
		System.out.println();
		
		// Proxy 설계도가  없으므로 안된다
//		Hello proxy = new Proxy(hello);
//		proxy.say();
		
		// 다운캐스팅:(Hello)
		// 클래스 설계도 없이 동적으로 프록시 객체를 만들었다.
		// 이 기술을 JDK Dynamic Proxy 라고 부른다.
		// 스프링은 타겟 객체가 인터페이스를 구현하고 있다면
		// JDK Dynamic Proxy 기술을 사용하여 프록시 객체를 만든다.
		Hello proxy = (Hello)Proxy.newProxyInstance(
				Hello.class.getClassLoader(),
				new Class[] {Hello.class},
				new MyAdvice(hello));
		proxy.say();
	}
}
