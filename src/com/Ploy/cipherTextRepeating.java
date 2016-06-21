package com.Ploy;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class cipherTextRepeating {
	
	public static HashMap<String, Integer> hash=new HashMap<String, Integer>();
	static String alpha="abcdefghijklmnopqrstuvwxyz";

	public static String plain,key;
	
	public cipherTextRepeating(String plain,String key){
		this.plain=plain;
		this.key=key;
		for (int i = 0; i < alpha.length(); i++) {
			hash.put(alpha.charAt(i)+"",i);
		}
		this.key = generateKey(this.key,this.plain.length());

	}
	
	public static String generateKey(String k,int text_length){
		String ret_key=k;
		while(ret_key.length() < text_length){
		ret_key+=k;
		}
		return ret_key.substring(0,text_length);
	}

	public static String findCipher() throws IOException{
		
		//final FileReader fr = new FileReader("poly.txt");
		//Scanner s = new Scanner(fr);
		
		String line="",cipher="";
		int row_num,col_num;
		
		for (int i = 0; i < plain.length(); i++) {
			row_num = hash.get(plain.charAt(i)+"");
			col_num = hash.get(key.charAt(i)+"");
			//System.out.println(row_num);
			line = Files.readAllLines(Paths.get("poly.txt"),Charset.defaultCharset()).get(row_num);
			line=line.replaceAll("\\s+","");
			//System.out.println(line);
			cipher+=line.charAt(col_num)+"";
		}
		return cipher;
	}
	
	public static String findPlainText(String cipher, String k) {
		k = generateKey(k,cipher.length());
		int cipher_index, key_index;
		String plain = "";
		for (int i = 0; i < cipher.length(); i++) {
			cipher_index = alpha.indexOf(cipher.charAt(i));
			key_index = alpha.indexOf(k.charAt(i));
			plain += alpha.charAt(((cipher_index - key_index) + 26) % 26);
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
		k=splitKey(k);
		return k;
	}

	public static String splitKey(String k) {
		String ret_str = "";
		int index = k.lastIndexOf(k.charAt(0));
		String sub_str = k.substring(index, k.length());
		if (k.substring(0,index).contains(sub_str)) {
			ret_str = k.substring(0,index);
		}
		index = ret_str.lastIndexOf(k.charAt(0));
		if(index>0){
		sub_str = ret_str.substring(index, ret_str.length());
		if (ret_str.substring(0,index).contains(sub_str)) {
			ret_str = k.substring(index,ret_str.length());
		}
		}
		
		/*if(index !=0){
		 * 
			String sub_str = k.substring(index, k.length());
			if (k.substring(0,index).contains(sub_str)) {
				ret_str = k.substring(0,index);
			} else
				ret_str = k;
		}
		else
			ret_str = k;*/
			
		return ret_str;
	}
	
	
}
