package com.AES;

public class AddRoundKey {

	static String [][] cipher_key ;
	static String [][] input ;
	static String [][] after_round=new String[4][4] ;
	
	public AddRoundKey(String [][] input ,String [][] key){
		this.input= input;
		cipher_key = key;
	}
	
	public String [][] intialRound(){
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				String str = MixColumns.xOR(Integer.toBinaryString(Integer.parseInt(input[j][i],16)),
						Integer.toBinaryString(Integer.parseInt(cipher_key[j][i],16)));
				int decimal = Integer.parseInt(str,2);
				after_round[j][i] = Integer.toString(decimal,16);
			}
			
		}
		return after_round;
	}
	
}
