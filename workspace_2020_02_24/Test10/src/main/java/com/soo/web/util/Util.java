package com.soo.web.util;


public class Util {

	public static int str2Int(String str) {
		
		String replace = str.replace("[^0-9]", "");
		
		int number = Integer.parseInt(replace);
		
		return number;
	}
	
	public static int str2Int2(String str) {
		return Integer.parseInt(str.replace("[^0-9]", ""));
	}
}
