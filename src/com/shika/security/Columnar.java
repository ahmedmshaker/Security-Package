package com.shika.security;

import java.util.ArrayList;
import java.util.HashMap;

public class Columnar {

	public String encrypt(String plain, String key) {
		key = key.toLowerCase().replaceAll("\\s", "");

		String Encryp = "";
		plain = plain.toLowerCase().replaceAll("\\s", "");
		ArrayList<Integer> keys = new ArrayList<>();
		ArrayList<String> arr = new ArrayList<>();
		while (plain.length() >= key.length()) {
			String sub = plain.substring(0, key.length());
			//System.out.println(sub);
			plain = plain.substring(key.length(), plain.length());
			arr.add(sub);
		}
		int size = plain.length();
		//System.out.println(size);
		if (size > 0) {

			for (int i = size; i < key.length(); i++) {
				plain += "x";
			}
			//System.out.println(plain);
			arr.add(plain);
		}

		int x = 1;
		for (int i = 0; i < key.length(); i++) {
			keys.add(Integer.parseInt(key.substring(i, x++)));
		}
		//System.out.println(arr.size());
		for (int i = 1; i < keys.size() + 1; i++) {

			for (int j = 0; j < arr.size(); j++) {
				/*
				 * System.out.println(arr.get(j).charAt(subkey - 1));
				 * System.out.println(subkey - 1);
				 */
				if (keys.indexOf(i)<arr.get(j).length()) {
					Encryp += arr.get(j).charAt(keys.indexOf(i));

				}
			}
		}

		return Encryp;
	}

	public String decrypt(String cipher, String key) {

		cipher = cipher.toLowerCase().replaceAll("\\s", "");
		key = key.toLowerCase().replaceAll("\\s", "");
		String Decryp = "";
		ArrayList<Integer> keys = new ArrayList<>();
		String[] arr = new String[key.length()];
		int length = (int) Math.ceil((double) cipher.length() / key.length());
		System.out.println(length);
		System.out.println(key.length());
		System.out.println(key);
		int x = 1;
		for (int i = 0; i < key.length(); i++) {
			keys.add(Integer.parseInt(key.substring(i, x++)));
		}
		
		int count = 0;
		System.out.println(arr.length);
		while (cipher.length() >= length) {
			String sub = cipher.substring(0, length);
			//System.out.println(sub);
			cipher = cipher.substring(length, cipher.length());
			//f(keys.indexOf(count +1)<keys.size())
			arr[keys.indexOf(count + 1)] = sub;
			count++;
		}
		

		System.out.println(cipher.length());
		//System.out.println(cipher);
		for (int i = 0; i < arr[0].length(); i++) {
			for (int j = 0; j < keys.size(); j++) {
				Decryp += arr[j].charAt(i);
			}
		}
		return Decryp;
	}

	public String analysis(String plain, String cipher) {

		plain = plain.replaceAll("\\s", "");
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < cipher.length() - 1; i++) {
			if (cipher.charAt(i) != cipher.charAt(i + 1)
					&& plain.charAt(i) != plain.charAt(i + 1)) {

				int x = Math.abs(plain.charAt(i) - plain.charAt(i + 1));
				--x;
				if (!map.containsKey(x)) {
					if (x > 1) {
						double k = (double)cipher.length() / x;
						//System.out.println(k);
						int temp = (int) k;
						if (temp == k && x!=cipher.length()) {
							map.put(x, 1);	
						}
						
					}
				} else {
					if (map.get(x) != null) {
						int l = map.get(x);
						++l;
						map.put(x, l);
					}

				}
			}
		}
		
		for (Integer key : map.keySet()) {
			String str="";
			for (int i = 1; i <= key; i++) {
				str+=i;
			}
			permutation(str, cipher, plain);
		}
		

		//System.out.println(key);

		return key;
	}
	
	 public  void permutation(String str , String cipher , String plain) { 
	        permutation("", str , cipher,plain); 
	    }

	 String key;
	    private  void permutation(String prefix, String str , String cipher , String plain) {
	        int n = str.length();
	        if (n == 0){
	        	try{
	        	String c = decrypt(cipher, prefix);
	        	System.out.println(prefix);
	        	if (c.equals(plain)) {
					key = prefix;
					return;
				}
	        	}catch(Exception e){
	        		System.out.println(e.getMessage());
	        	}
	        }
	        else {
	            for (int i = 0; i < n; i++)
	                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n) , cipher , plain);
	        }
	    }
}
