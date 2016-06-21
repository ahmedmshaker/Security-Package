package com.shika.security;

public class Monoalphabetic {

	public String encrypt(String plain , String key) {

		plain = plain.replaceAll("\\s", "");
		Utils.setKey(key);
		String Encypt = "";
		for (int i = 0; i < plain.length(); i++) {
			Encypt += Utils.getCharachterAt(plain.toLowerCase().charAt(i));
		}
		return Encypt;
	}

	public String decrypt(String cipher , String key) {

		cipher = cipher.replaceAll("\\s", "");
		Utils.setKey(key);
		String Decryp = "";
		for (int i = 0; i < cipher.length(); i++) {
			Decryp += Utils.getKeyFromValue(cipher.toLowerCase().charAt(i));
		}
		return Decryp;
	}

}
