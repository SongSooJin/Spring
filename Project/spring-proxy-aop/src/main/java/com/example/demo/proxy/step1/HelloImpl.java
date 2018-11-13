package com.example.demo.proxy.step1;

public class HelloImpl implements Hello{

	@Override
	public void say() {
		System.out.println("------------");
		System.out.println("도넛맨 왔다감~!!!");
		System.out.println("============");		
	}
	
	public void say2() {
		System.out.println("도넛맨 왔다감2~!!!");
	}
}
