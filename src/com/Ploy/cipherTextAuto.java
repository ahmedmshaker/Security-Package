package com.Ploy;
import java.awt.AlphaComposite;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class cipherTextAuto {
	public static HashMap<String, Integer> hash=new HashMap<String, Integer>();
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	private static String plain, key;

	// public static HashMap<String, Integer> hash=new HashMap<String,
	// Integer>();

	public cipherTextAuto(String plain, String key) {
		this.plain = plain;
		this.key = key;
		for (int i = 0; i < alpha.length(); i++) {
			hash.put(alpha.charAt(i)+"",i);
		}
		this.key = generateKey(this.key,this.plain);
	}

	public static String generateKey(String k, String text) {
		String ret_key = k + text;
		return ret_key.substring(0, text.length());
	}

	public String findCipher() throws IOException {

		String line = "", cipher = "";
		int row_num, col_num;

		for (int i = 0; i < plain.length(); i++) {
			row_num = hash.get(plain.charAt(i) + "");
			col_num = hash.get(key.charAt(i) + "");
			// System.out.println(row_num);
			line = Files.readAllLines(Paths.get("poly.txt"),Charset.defaultCharset()).get(row_num);
			line = line.replaceAll("\\s+", "");
			// System.out.println(line);
			cipher += line.charAt(col_num) + "";
		}
		return cipher;
	}

	public static String findPlainText(String cipher, String k) {
		
		//k = generateKey(k,cipher);
		System.out.println(k);
		cipher = cipher.toLowerCase();
		   k = k.toLowerCase();
		int cipher_index, key_index;
		String plain = "";
		for (int i = 0; i < cipher.length(); i++) {
			cipher_index = alpha.indexOf(cipher.charAt(i));
			key_index = alpha.indexOf(k.charAt(i));
			int index =(cipher_index - key_index)%26 ;
			if(index <0)
				index+=26;
			plain += alpha.charAt(index);
			k += alpha.charAt(index);
		}
		return plain;
		
		
		
	}

	public static String findKeyWord(String cipher, String plain) {
		int cipher_index, key_index;
		String k = "";
		for (int i = 0; i < cipher.length(); i++) {
			cipher_index = alpha.indexOf(cipher.charAt(i));
			key_index = alpha.indexOf(plain.charAt(i));
			k += alpha.charAt(((cipher_index - key_index) + 26) % 26);
		}
		k=splitKey(plain, k);
		return k;
	}

	public static String splitKey(String plain, String k) {
		String ret_str = "";
		if (k.contains(plain.charAt(0) + "")) {
			int index = k.indexOf(plain.charAt(0));
			String sub_str = k.substring(index, k.length());
			if (plain.contains(sub_str)) {
				ret_str = k.replaceAll(sub_str, "");
			} else
				ret_str = k;
		}
		else
			ret_str = k;
			
		return ret_str;
	}

}
