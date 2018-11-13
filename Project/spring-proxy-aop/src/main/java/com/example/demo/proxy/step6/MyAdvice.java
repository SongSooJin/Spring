package com.example.demo.proxy.step6;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 타켓 클래스의 핵심로직 앞/뒤로 수행해야 하는 로직이 무엇인지
// 보유하고 있는 클래스이다.
public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		   
		      System.out.println("------Around Before Advice------");
		      
		      Object ret = invocation.proceed(); // Delegation(위임)
		      
		      System.out.println("======Around After Advice======");

		return null;
	}

	
}
