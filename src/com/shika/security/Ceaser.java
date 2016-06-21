package com.shika.security;

public class Ceaser {

	public String encrypt(String plain, int key) {

		plain = plain.replaceAll("\\s", "");
		String Encrep = "";
		for (int i = 0; i < plain.length(); i++) {
			int num = (int) plain.charAt(i) - 97;
			int res = (num + key) % 26;
			Encrep += (char) (97 + res);
		}
		return Encrep;
	}

	public String decrypt(String cipher, int key) {

		cipher = cipher.replaceAll("\\s", "");
		String Decryp = "";
		for (int i = 0; i < cipher.length(); i++) {
			int num = (int) cipher.charAt(i) - 97;
			int res = (num - key) % 26;
			if (res < 0) {
				res += 26;
			}
			Decryp += (char) (97 + res);
		}
		return Decryp;
	}

	public int cryptanalysis(String plain, String cipher) {
		int num = (int) cipher.charAt(0) - plain.charAt(0);
		if (num < 0) {
			num += 26;
		}
		return num;
	}

}
