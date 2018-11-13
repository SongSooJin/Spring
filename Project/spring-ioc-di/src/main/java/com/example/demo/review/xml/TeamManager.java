package com.example.demo.review.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  TeamManager use Employee. 
 * 	팀메니저가 임플로이를 사용한다.
 * 
 *  TeamManager has Employee.
 *  팀메니저가 임플로이를 가지고 있어야 한다.
 *  
 *  TeamManager depends Employee.
 *  팀메니저가 임플로이를 의존한다. 즉  팀메니저가 임플로이를 사용한다.
 *   
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamManager {
//	private Employee worker = new Programmer();
//	private Employee worker = new Designer();
	private Employee worker;
	
	public void order() {
		System.out.println("TeamManager가 " + worker.getClass().getSimpleName() + "에게 일을 시킨다..");
		worker.work();
	}
}

