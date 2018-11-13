package com.example.demo.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.ioc.step7.OrderManager;
import com.example.demo.review.anno.TeamManager;

@Component
public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("qualifier-test.xml");
		
		TheClientBean clientBean = (TheClientBean) context.getBean("clientBean");
		
		clientBean.getList().forEach(System.out::println);
	}

}
