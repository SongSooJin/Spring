package com.soo.util;

public class Util {

	//String to Integer
	//문자열로 들어온것 숫자로 바꾸기
	
	public static int str2Int(String str) {
	//누구나 들어올수 있고 반환 타입이 int이고 str2Int메소드에 String의 타입의 str이 옴 	
		
		//로직 
//		for (int i = 0; i < str.length(); i++) {
//			if(str.split(i) > 아스키코드  0 || 아스키코드 < 9) {
//				//따로 모으기
//			}
		
				int num = Integer.parseInt(str.replaceAll("[^0-9]", ""));
				//정규식을 이용해서 문자열 중 숫자가 아닌 것을 지움 ^=아닌것
				return num;//내보내기
			}
			
			//숫자 체크 : 문자열을 숫자로 변환 할 수 있는지를 물어봄
			public static boolean checkInt(String str) {
				
				try {
					Integer.parseInt(str);			
				} catch (Exception e) {
					return false;//변환하지 못하면 거짓으로
				}
				return true;//변환 가능하면 참으로
			}
		}

// Util.str2Int("152");
