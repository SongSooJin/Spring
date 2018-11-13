package com.example.demo.hw;

import java.lang.reflect.Method;
import java.util.Random;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.stereotype.Component;


@Component
public class SafetyBeltCheckAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if(!(SafetyBeltCheckSensor.check())) {
			System.out.println("딩동~! 안전벨트를 착용하세요!");
						
	}
		return null;
	}

//	@Override
//	public Object invoke(MethodInvocation invocation) throws Throwable {
//		
//		
//		
//		
//		if(!(SafetyBeltCheckSensor.check())) {
//			System.out.println("딩동~! 안전벨트를 착용하세요!");
//						
//	}
//		return throw new Throwable();
//	}
}
	

	// 자동차의 start 메소드가 호출되면
	// 안전 벨트 착용여부를 확인하여 착용했으면
	// 엔진을 기동시키고
	// 착용하지 않았으면 경고음을 들려준다.
	

class SafetyBeltCheckSensor {

	static Random rnd = new Random();

	public static boolean check() {
		// 50% 확률로 true를 리턴한다.
		if (rnd.nextInt(2) == 0) {
			return true;
		}
		return false;
	}

}