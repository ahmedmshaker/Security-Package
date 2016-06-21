package com.shika.security;


public class RailFence {

	public String encrypt(String plain, int depth) {
		plain = plain.toLowerCase().replaceAll("\\s", "");
		System.out.println(plain.length());

		int length = (int) Math.ceil((double) plain.length() / 2);
		char[][] c = new char[depth][length];

		String Encryp = "";
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < depth; j++) {
				if (count < plain.length()) {
					c[j][i] = plain.charAt(count);
				} else {
					c[j][i] = ' ';
				}
				count++;
			}
		}
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < length; j++) {
				Encryp += c[i][j];
			}
		}
		return Encryp.replaceAll("\\s", "");

	}

	public String decrypt(String cipher, int depth) {
		cipher = cipher.toLowerCase().replaceAll("\\s", "");
		System.out.println(cipher.length());

		int length = (int) Math.ceil((double) cipher.length() / depth);
		char[][] c = new char[depth][length];

		String DEcryp = "";
		int count = 0;
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < length; j++) {
				if (count < cipher.length()) {

					c[i][j] = cipher.charAt(count++);
				} else {
					c[i][j] = 'x';
				}
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < depth; j++) {

				DEcryp += c[j][i];
			}
			System.out.println();
		}
		return DEcryp.replaceAll("x", "");
	}

	public int cryptanalysis(String plain, String cipher) {


		for (int i = 1; i <= cipher.length(); i++) {
			String cipherTemp = encrypt(plain, i);
			if (cipher.equals(cipherTemp)) {
				return i;
			}

		}
		

		return plain.indexOf(cipher.charAt(1));
	}

}
