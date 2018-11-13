package com.example.demo.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import lombok.Data;

@Data
public class Example {
	private Set<Object> set;
	private Map<String, Object> map; // key,value 값 
	private List<Object> list;
	private Properties prop; // 키도 스트링 값도 스트링  여름/Summer
}
