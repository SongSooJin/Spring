package com.example.demo.qualifier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("clientBean")
public class TheClientBean {

	@Autowired
	@Qualifier("myService")
	private List<TheService> list;
	
	
}

