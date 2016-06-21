package com.AES;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Decryption {
	
	static ArrayList<String[]> keys;
	static String[][] cipher_key = new String [4][4];
	static String[][] cipher = new String [4][4];
	public Decryption(String ciph,String key) {
		 ciph= ciph.toLowerCase();
		cipher = Encryption.putInput(ciph);

		key = key.toLowerCase();
		cipher_key = Encryption.putInput(key);
		
	}

	public static String decryption() throws IOException {
		
		 keys = new KeySchedule(cipher_key,"encryption").generateNewKey();
		String[][] sub_40_43 = Encryption.subKey(keys, 40);
		String[][] intial_input = new AddRoundKey(cipher, sub_40_43)
				.intialRound();
		System.out.println("_____________");
		for (int j = 0; j < cipher.length; j++) {
			for (int k = 0; k < cipher.length; k++) {
				System.out.print(intial_input[j][k] + " ");
			}
			System.out.println();
		}
		
		String[][] plain = new String[4][4];
		String[][] sub = new String[4][4];
		int index = 36;
		for (int i = 0; i < 10; i++) {
			intial_input = new Inv_ShiftRows(intial_input).shift();
			intial_input = new Inv_SubBytes(intial_input).inv_SubBytes();
			if (i != 9){
				sub = Encryption.subKey(keys, index);
				intial_input = new AddRoundKey(intial_input, sub).intialRound();
				intial_input = new Inv_MixColumns(intial_input).inversedColumns();

			}
			else{
				sub = Encryption.subKey(keys, index);
				intial_input = new AddRoundKey(intial_input, sub).intialRound();

			}

			index -= 4;
			plain = intial_input;
		}

		System.out.println("The Plain Text is : ");
		
		String plainText="";
		for (int j = 0; j < plain.length; j++) {
			for (int k = 0; k < plain.length; k++) {

				if (plain[k][j].length() > 2) {

					int decimal = Integer.parseInt(plain[k][j], 2);
					plain[k][j] = Integer.toString(decimal, 16);
				}
				if (plain[k][j].length() == 1)
					plain[k][j] = "0" + intial_input[k][j];
				plainText+=plain[k][j];
		}
	}
		return plainText;
	}
}
