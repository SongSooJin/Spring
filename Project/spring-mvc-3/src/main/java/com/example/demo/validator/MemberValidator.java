package com.example.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.demo.dto.Member;

public class MemberValidator implements Validator {
	// 데이터를 갖고 있는 객체와 
	// 데이터의 유효성을 체크하여 여러정보를 갖고 있는 객체를 연결 한다.
	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	// Member member, BindingResult result
	// valid.validate(member, result);
	@Override
	public void validate(Object target, // 사용자가 작성한 데이터를 보관하는 객체
			Errors errors) { // 데이터를 검증한 결과(에러정보)를 보관하는 객체
		// ValidationUtils.rejectIfEmptyOrWhitespace(
		// errors, "name", "required.name", "이름이 필요합니다.");
		
		// xxx.properties 파일안에
		// required.address = address 항목이 빈 문자열입니다... 에러메세지 
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "주소가 필요합니다.");
		// 타겟 객체에 있는 멤버변수 "address"를 조사 비어있는건가 아니면 있는데 스페이스눌러서 공백인거냐 해서 에러를 결정  
		// "required.address","주소가 필요합니다."은 or 3번이 없으면 4번을쓰고 4번이 없으면 3번을 쓰고 
		
		// Member member = (Member) target;
		// System.out.println("-----------------------");
		// System.out.println(member);
		// System.out.println("=======================");
			}
}
