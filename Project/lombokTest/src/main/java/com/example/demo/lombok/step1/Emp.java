package com.example.demo.lombok.step1;



import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;



@Data // 아래의 기능을  만들어줌 
/* 
 * Equivalent to
	@Getter 
	@Setter 
	@RequiredArgsConstructor
	@ToString 
	@EqualsAndHashCode.
*/ 

@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	
	private int empno;
	private String ename;
	private String job;
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "{"+ empno + "," + ename + "," + job + "}";
//		
//	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Emp)) {
//			throw new RuntimeException("Use EMp instance")
//		}
//		Emp that = (Emp) obj;
//		if (this.empno == that.empno) {
//			return true;
//		}
//		return false;
//	}
	
}
