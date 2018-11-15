package com.example.demo.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Emp;

//개발자 테스트 클래스 ~~ SpringJUnit[JUnit]
@RunWith(SpringJUnit4ClassRunner.class)
//테스트를 위한 빈 컨테이너 설정파일을 통보한다.
//file: 파일의 기준위치는 자바 측이 아니라 웹루트 밑이라고 구분해 준다.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class EmpServiceImplTest {

	@Autowired
	private EmpService empService;

	@Test
	public void testInsert() {
		int oldCount = 0;
		try {
			oldCount = empService.count();
		} catch (Exception ignore) {

		}
		System.out.println("oldCount = " + oldCount);

		Emp emp = new Emp();
		emp.setEmpno(3201);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);

		try {
			int affected = empService.insert(emp);
			System.out.println("insert affected = " + affected);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int nowCount = 0;
		try {
			nowCount = empService.count();
		} catch (Exception ignore) {}

		System.out.println("nowCount = " + nowCount);
		assertEquals("insert 메소드에서 예외발생, 트랜잭션 어드바이스 적용, " + "롤백이 되어야 하기 때문에 oldCount 값과 nowCount 값은 같아야 한다.", oldCount,
				nowCount);
	}

	@Test
	public void testDelete() {
		
		try {
			int oldCount = empService.count();
			System.out.println("oldCount = " + oldCount);
		} catch (Exception ignore) {}
	
		Emp emp = new Emp();
		emp.setEmpno(4444);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);
		
		try {
			int affected = empService.insert(emp);
			System.out.println("insert affected = " + affected);
		} catch (Exception ignore) {}
		
		try {
			int insertAfteraffected = empService.insert(emp);
			System.out.println("insertAfteraffected = " + insertAfteraffected);
		} catch (Exception ignore) {}

		
		try {
			int affected = empService.delete(4444);
			System.out.println("delete affected = " + affected);
		} catch (Exception ignore) {}
		
		try {
			int nowCount = empService.count();
			System.out.println("nowCount = " + nowCount);
		} catch (Exception ignore) {}
		
	}
	
	// 다음 2개의 애노테이션을 동시에 설정하면 메소드가 종료된 후 메소드 내에서
	// 행한 모든 쿼리작업이 롤백된다.
	@Transactional
	@Test
	public void testUpdate() {
		
		Emp emp = new Emp();
		emp.setEmpno(4444);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);
		
		
		
		try {
			int affected = empService.insert(emp);
			System.out.println("insert affected = " + affected);
		} catch (Exception ignore) {}
		
		System.out.println("수정 전 : " + emp);
		
		try {
			emp.setEname("후이");
			int affected = empService.update(emp);
			System.out.println("update affected = " + affected);
		} catch (Exception ignore) {}
		
		System.out.println("수정 후 : " + emp);
		
//		try {
//			int affected = empService.delete(emp.getEmpno());
//			System.out.println("delete affected = " + affected);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
	}
	
	@Test
	public void testFindOne() {
		try {
			Emp emp = empService.findOne(4444);
			System.out.println(emp);
		} catch (Exception ignore) {}
	}
}
