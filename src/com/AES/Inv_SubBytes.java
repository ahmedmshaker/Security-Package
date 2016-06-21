package com.AES;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class Inv_SubBytes {

	static String[][] cipher;
	public static HashMap<String,Integer> hash=new HashMap<String, Integer>();
	public static String [][] res=new String [4][4] ;
	
	public  Inv_SubBytes(String[][] cipher) {
		 this.cipher = cipher;
		 intialize();
	} 
	 
	public static String[][] inv_SubBytes() throws IOException {
		
		int first,second;
		String line;
		
		for (int i = 0; i < cipher.length; i++) {
			for (int j = 0; j < cipher.length; j++) {
				
				if(cipher[i][j].length() >2){
					int decimal = Integer.parseInt(cipher[i][j], 2);
					cipher[i][j] = Integer.toString(decimal, 16);
				}
				if(cipher[i][j].length() ==1)
					cipher[i][j]="0"+cipher[i][j];
				first = hash.get(cipher[i][j].charAt(0)+""); 
				second= hash.get(cipher[i][j].charAt(1)+""); 
				line =Files.readAllLines(Paths.get("inv_SBox.txt" ),Charset.defaultCharset()).get(first);
				line = line.replaceAll("\\s+", "");
				//System.out.println(line);
				//System.out.println(second);
				res[i][j]=line.charAt(second*2)+""+line.charAt(second*2+1)+"";
			}
		}
		return res;
	}
	public static void intialize(){
		
		hash.put("0", 0);
		hash.put("1", 1);
		hash.put("2", 2);
		hash.put("3", 3);
		hash.put("4", 4);
		hash.put("5", 5);
		hash.put("6", 6);
		hash.put("7", 7);
		hash.put("8", 8);
		hash.put("9", 9);
		hash.put("a", 10);
		hash.put("b", 11);
		hash.put("c", 12);
		hash.put("d", 13);
		hash.put("e", 14);
		hash.put("f", 15);
		
	}
	
		
}
