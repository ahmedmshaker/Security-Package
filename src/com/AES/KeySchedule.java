package com.AES;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class KeySchedule {

	static String[][] rcon = new String[][] {
			{ "01", "02", "04", "08", "10", "20", "40", "80", "1b", "36" },
			{ "00", "00", "00", "00", "00", "00", "00", "00", "00", "00" },
			{ "00", "00", "00", "00", "00", "00", "00", "00", "00", "00" },
			{ "00", "00", "00", "00", "00", "00", "00", "00", "00", "00" } };
	static ArrayList<String[]> all_keys = new ArrayList<>();
	static String mode="";
	
	public KeySchedule(String [][] key,String mode) {
		this.mode = mode;
		String[] col;
		for (int i = 0; i < key.length; i++) {
			col = new String[4];
			for (int j = 0; j < key.length; j++) {
				col[j] = key[j][i];
			}
			all_keys.add(col);
		}
	}

	public static ArrayList<String[]> generateNewKey() throws IOException {
		String[] last_col;
		String[] first_col;
		String[] rcon_col = new String[4];
		// String[] other_col = new String[4];
		String[] new_col;
		int temp = 0;

		for (int i = 0; i < rcon[0].length*4; i++) {
			new_col = new String[4];
			last_col = new String[4];
			first_col = new String[4];
			for (int j = 0; j < last_col.length; j++) {
				last_col[j] = all_keys.get(all_keys.size() - 1)[j];
				first_col[j] = all_keys.get(all_keys.size() - 4)[j];
			}

			if (i % 4 == 0) {
				for (int j = 0; j < rcon_col.length; j++) {
					rcon_col[j] = rcon[j][temp];
					// System.out.println(rcon[j][temp]+" ");
				}
				temp++;

				/*for (int j = 0; j < last_col.length; j++) {
					System.out.println("last===="+last_col[j]+" ");
				}
				for (int j = 0; j < last_col.length; j++) {
					System.out.println("first===="+first_col[j]+" ");
				}*/
				
				new_col = shiftCol(last_col);
				new_col = findSBox(new_col);
				
				new_col = xOR(new_col, rcon_col);
				new_col = xOR(new_col, first_col);

				all_keys.add(new_col);
			} else {
				new_col = xOR(last_col, first_col);
				all_keys.add(new_col);
			}
			//System.out.println(("===="+all_keys.size()));

		}
		/*
		 * for (int i = 4; i < all_keys.size(); i++) { for (int j = 0; j <
		 * all_keys.get(i).length; j++) { String str =
		 * Integer.toHexString(Integer.parseInt(all_keys.get(i)[j]+""));
		 * all_keys.get(i)[j]=MixColumns.checkForSize(str);
		 * System.out.print(all_keys.get(i)[j]+" "); } System.out.println(); }
		 */
		return all_keys;
	}

	public static String[] shiftCol(String[] col) {
		String temp = "";
		for (int i = 0; i < col.length; i++) {
			if (i == 0)
				temp = col[i];
			if (i == col.length - 1)
				col[i] = temp;
			else
				col[i] = col[i + 1];
		}
		return col;
	}

	public static String[] findSBox(String[] col) throws IOException {
		int first, second;
		String line="";
		for (int j = 0; j < col.length; j++) {
			if (col[j].length() != 2) {
				int decimal = Integer.parseInt(col[j],2);
				String str1 = Integer.toString(decimal,16);
				if(str1.length()==1)
					str1="0"+str1;
				//System.out.println("////////"+ str1);
				SubBytes.intialize();
				first = SubBytes.hash.get(str1.charAt(0) + "");
				second = SubBytes.hash.get(str1.charAt(1) + "");
				//if(mode.equals("encryption"))
				line = Files.readAllLines(Paths.get("s-box.txt"),Charset.defaultCharset()).get(first);
				//else if(mode.equals("decryption"))
					//line = Files.readAllLines(Paths.get("inv_SBox.txt")).get(first);
				line = line.replaceAll("\\s+", "");
				String str = line.charAt(second * 2) + ""
						+ line.charAt(second * 2 + 1) + "";
				int num = (Integer.parseInt(str, 16));
				str = Integer.toBinaryString(num);
				col[j] = MixColumns.checkForSize(str);
			} else {
				//System.out.println(col[j]);
				SubBytes.intialize();
				first = SubBytes.hash.get(col[j].charAt(0) + "");
				second = SubBytes.hash.get(col[j].charAt(1) + "");
				if(mode.equals("encryption"))
					line = Files.readAllLines(Paths.get("s-box.txt"),Charset.defaultCharset()).get(first);
				else if(mode.equals("decryption"))
					line = Files.readAllLines(Paths.get("inv_SBox.txt"),Charset.defaultCharset()).get(first);
				line = line.replaceAll("\\s+", "");
				String str = line.charAt(second * 2) + ""
						+ line.charAt(second * 2 + 1) + "";
				int num = (Integer.parseInt(str, 16));
				str = Integer.toBinaryString(num);
				col[j] = MixColumns.checkForSize(str);
			}
		}
		return col;
	}

	public static String[] xOR(String[] col, String[] col1) {
		String[] ret = new String[4];
		for (int i = 0; i < col.length; i++) {
			// System.out.println(col[i]+"   "+col1[i]);
			if (col[i].length() <= 2) {
				int num = (Integer.parseInt(col[i], 16));
				String str = Integer.toBinaryString(num);
				if (col1[i].length() <= 2) {
					int num1 = (Integer.parseInt(col1[i], 16));
					String str1 = Integer.toBinaryString(num1);
					ret[i] = MixColumns.xOR(str, str1);
				} else
					ret[i] = MixColumns.xOR(str, col1[i]);
			} else {
				if (col1[i].length() <= 2) {
					int num1 = (Integer.parseInt(col1[i], 16));
					String str1 = Integer.toBinaryString(num1);

					ret[i] = MixColumns.xOR(col[i], str1);

				} else
					ret[i] = MixColumns.xOR(col[i], col1[i]);
			}

		}
		return ret;
	}

	private static boolean isHexNumber(String cadena) {
		try {
			Long.parseLong(cadena, 16);
			return true;
		} catch (NumberFormatException ex) {
			// Error handling code...
			return false;
		}
	}
}
