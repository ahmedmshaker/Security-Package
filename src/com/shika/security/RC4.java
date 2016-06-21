package com.shika.security;

import java.util.ArrayList;

public class RC4 {

	private int[] s;
	private int[] t;

	private void initialze(ArrayList<Integer> key) {
		s = new int[256];
		t = new int[256];
		for (int i = 0; i < 255; i++) {
			s[i] = i;
			t[i] = key.get(i % key.size());
		}
	}

	private void initialPermutations() {
		int j = 0;
		for (int i = 0; i < 255; i++) {
			
			j = (j + s[i] + t[i] ) % 256;
		//	System.out.println(Integer.parseInt(t[i], 16));
			swap(i, j, s);
			
		}
	}

	private String streamGenerator(ArrayList<Integer> plain) {
		String cipher = "";
		int i = 0, j = 0, x = 0;
		System.out.println();
		System.out.println(plain.size());
		while (x < plain.size()) {
			i = (x + 1) % 256;
			j = (j + s[i]) % 256;
			swap(i, j, s);
			int z = s[(s[i] + s[j]) % 256];
			//int temp = (s[i] + s[j]) % 256;
			int n1 = plain.get(x);
			//int n2 = t[s[temp]]%256;
			int n3 = z ^ n1;
			cipher += (char)n3;
			System.out.print(n3);
			x++;

		}

		System.out.println();
		return cipher;

	}

	void swap(int i, int j, int[] arr) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	private ArrayList<Integer> fromStringToHex(String s) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			
				arr.add((int)s.charAt(i));
				System.out.println();
				System.out.println(arr.get(i));

		}
		return arr;
	}

	/*private boolean isHexNumber(String cadena) {
		try {
			Long.parseLong(cadena, 16);
			return true;
		} catch (NumberFormatException ex) {
			// Error handling code...
			return false;
		}
	}*/

	public String encrypt(String plain, String key) {
		ArrayList<Integer> mKey = fromStringToHex(key);
		ArrayList<Integer> mPlain = fromStringToHex(plain);
		System.out.println(mPlain.size());
		initialze(mKey);
		initialPermutations();
		return streamGenerator(mPlain);
		// return "ahmed";

	}

	public String decrypt(String cipher, String key) {
		return encrypt(cipher, key);    
	}

}
