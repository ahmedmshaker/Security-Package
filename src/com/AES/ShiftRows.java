package com.AES;
public class ShiftRows {

	static String[][] input;
	static String[][] res = new String[4][4];

	public ShiftRows(String[][] input) {
		// TODO Auto-generated constructor stub
		this.input = input;
	}

	public static String[][] shift() {
		String temp = "";
		for (int i = 0; i < input.length; i++) {
			for (int j2 = 0; j2 < i; j2++) {
				for (int j = 0; j < input.length; j++) {
					if (i == 0) {
						break;
					}
					if (j == 0)
						temp = input[i][j];
					if (j == input.length - 1) {
						input[i][j] = temp;
						break;
					}

					else {
						input[i][j] = input[i][j + 1];
					}
				}
			}
		}
		return input;
	}
}
