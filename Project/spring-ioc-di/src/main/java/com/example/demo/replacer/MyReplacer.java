package com.example.demo.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class MyReplacer implements MethodReplacer {


	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return "후이 ♡ 송수진";
	}
}