package com.example.demo.sqle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

/*
 * 다음 중 하나를 사용하여 설정하면 my.properties 파일에 
 * 설정한 값을 키값으로 변수에 할당할 수 있다.
 * <context:property-placeholder location="my.properties"/>
 * @PropertySource(value = { "my.properties" })
 */

//<context:property-placeholder location="my.properties"/>
@PropertySource(value = { "my.properties" })
@Component
@Data
public class Person {
	@Value("#{member.name}")
	private String name;
	
	@Value("#{member.age}")
	private int age;
	
	// mull 설정 : car.default.name 키로 찾았는데 없으면 대신 null할당한다.
	@Value("${car.default.name:null}")
	private String carName;
	
	@Value("${car.default.doors:0}")
	private int carDoors;
	
	// Run As > Run Configuration > VM arguments > -Duser.region=KR
	// java -jar 빌드된파일 .jar -Duser.region=KR
	@Value("#{systemProperties['user.region'] == null ? 'US' : systemProperties['user.region']}")
	private String defaultLocale;
}
