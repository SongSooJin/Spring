package com.example.demo.lombok.step1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data // 아래의 기능을  만들어줌 
/* 
 * Equivalent to
	@Getter 
	@Setter 
	@RequiredArgsConstructor
	@ToString 
	@EqualsAndHashCode.
*/ 

@Getter 
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class Member {

	@NonNull private int id;
	@NonNull private String name;
	private String email;
	
//	// 직접접근은 안되지만 메소드가 public이기 때문에 접근 가능 
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	
	
}
