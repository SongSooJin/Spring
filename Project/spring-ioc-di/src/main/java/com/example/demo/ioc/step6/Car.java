package com.example.demo.ioc.step6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 상태를 보관하는 용도의 클래스를 관점에 따라서 다음과 같이 부른다.
 * 
 * VO(Value Object), DTO(Data Transfer Object), 
 * Domain, Model, Entity(ORM 기술에서 사용)
 * */

// 일반적으로 VO는 빈 컨테이너에 등록해서 사용하지 않는다.
// 왜냐하면, VO는 데이터를 보관하거나 전송하는 용도로 쓰이기 때문에 매번 값이 변경된다.
// 스프링 빈 컨테이너에 등록된 객체는 기본적으로 Singletond으로 관리한다.
// 따라서, 꼭 필요한 경우가 아니라면 VO는 빈 컨테이너에 등록해서 사용하지 않는다.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private String name;

}
