package com.example.demo.lombok.step1;



public class EmpTest2 {

	public static void main(String[] args) {
		Emp emp = new Emp(10,"Soo","Developer");
		Emp emp2 = emp;
		
		// 동일비교 
		System.out.println(emp == emp2); // true
		
		Emp emp3 = new Emp(10,"Soo","Developer");
		
		System.out.println(emp == emp3); // false
		
		// 객체는 참조가 다르면 다르다고 판단해야 한다.
		// 하지만, 때때로 객체가 별도로 각각 존재하더라도 객체의 상대값이 같은 경우 
		// 같다고 판단해야 할 때가 있다.
		
		// 예 : 브라우저 id/pw 정보를 전달한다.
		// 디비가 id/pw 정보를 전달한다.
		// 개발자는 로그인 처리를 위해서 두 객체가 가진 정보를 비교하여 같으면 true 라고 처리해야 한다.
		// 두 객체는 참조는 다르지만 값은 같고, 이경우, true라고 판단해야 한다.
		
		// 이럴 때, 클래스의  equals 메소드를 재정의 해서 사용한다.
		// equals 메소드를 재정의 하지 않으면 기본적으로  == 비교연산자와 동일하게 행동한다.
		
		System.out.println(emp.equals(emp3)); // false
		// @EqualsAndHashCode 설정후 =>  true
		
	}
}
