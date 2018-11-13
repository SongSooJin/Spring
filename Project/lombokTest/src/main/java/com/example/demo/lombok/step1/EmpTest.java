package com.example.demo.lombok.step1;



public class EmpTest {

	public static void main(String[] args) {
		Emp emp = new Emp(10,"Soo","Developer");
		
		System.out.println(emp.getEmpno());
		
		
		System.out.println(emp.toString());
		System.out.println(emp);
		// com.example.demo.lombok.step1.Emp@15db9742
		// Emp 클래스에서 toString() 메소드를 재정의 한 후  => {10,Soo,Developer}
		
		// @ToString 애노테이션으로  ToString() 메소드를 재 정의한 후 
		// => Emp(empno=10, ename=Soo, job=Developer)
	}

}
