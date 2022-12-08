package com.nmkg.tesla;

import java.util.HashMap;

public class TeslaBaloon {
	static String inputWord = "BALLOON";
	
	

	static int solution(String inputStr) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>(); 
		for (int i = 0; i < inputStr.length(); i++) {
			char c = inputStr.charAt(i);
			if (charMap.containsKey(c)) { 
				charMap.replace(c, charMap.get(c), charMap.get(c) + 1);
			}else {
				charMap.put(c, 1); 
			}

		}
		
		for (int i = 0; i < inputWord.length(); i++) {
			if (!charMap.containsKey(inputWord.charAt(i))) {
				return 0;
			}
		}
		return getMinVal(charMap.get('B'), charMap.get('A'), charMap.get('L') / 2, charMap.get('O') / 2, charMap.get('N'));

	}

	static int getMinVal(int var1, int var2, int var3, int var4, int var5) { 
		return Math.min(Math.min(Math.min(var1, var2), Math.min(var3, var4)), var5);
	}
	
	public static void main(String[] args) {
		String str = "BAONXXOLL";
		System.out.println(str + ":: " + solution(str));
		
		str = "BAOOLLNNOLOLGBAX";
		System.out.println(str + ":: " + solution(str));
		
		str = "QAWABAWONL";
		System.out.println(str + ":: " + solution(str));
		
		str = "ONLABLABLOON";
		System.out.println(str + ":: " + solution(str));

	}

}
