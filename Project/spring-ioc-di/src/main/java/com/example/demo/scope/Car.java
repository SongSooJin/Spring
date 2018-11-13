package com.example.demo.scope;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

// @Order(2) : 자료형이 같은 객체 다수가 빈 컨테이너에 존재할 때,
// 처리순서를 지정한다. 낮은 숫자가 먼저 처리된다.
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
