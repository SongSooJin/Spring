package com.example.demo.scope;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("car2")
@Scope("prototype")
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 위의 코드(@Scope("prototype"))와 같은 의미
@Data
public class Car {

	public String name;
	public String maker;

	public Car() {
//			this.name = "K9";
//			this.maker = "Kia";
	}

	// spring이 PostConstruct를 호출한다.
	// PostConstruct는 실제로 많이 쓰임.
	@PostConstruct
	public void init() {
		if (name == null || maker == null) {
			this.name = "K9";
			this.maker = "Kia";
		}
	}
}
