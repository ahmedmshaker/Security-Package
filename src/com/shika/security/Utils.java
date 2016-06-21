package com.shika.security;

import java.util.HashMap;

public class Utils {

	
	public static HashMap<Character, Character> alphapet ;
	
	public static void setKey(String key) {
		alphapet = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			alphapet.put((char) (97 + i), Character.toLowerCase(key.charAt(i)));
		}
	}

	public static Character getCharachterAt(char c) {
		
		System.out.println(c);
		return alphapet.get(c);
	}

	public static Character getKeyFromValue(char value) {
		for (Character o : alphapet.keySet()) {
			if (alphapet.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}

}
