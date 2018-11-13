package com.example.demo.replacer;

import lombok.Data;

@Data
public class Magician {

	private MagicBox box;
	
	public void show() {
		System.out.println("마술사가 마술상자를 엽니다리리리. 나니데쓰까? ");
		String result = box.open();
		System.out.println("호로로로로로로롤~~!! " + result + "가 나왔다용!");
	}
}
