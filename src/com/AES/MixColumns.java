package com.AES;
public class MixColumns {

	public static String[][] mix_matrix = { { "02", "03", "01", "01" },
			{ "01", "02", "03", "01" }, { "01", "01", "02", "03" },
			{ "03", "01", "01", "02" } };
	static String[][] input;
	static String[][] ret_matrix = new String[4][4];
	static final String mul_const = "00011011";


	public MixColumns(String[][] input) {
		this.input = input;
	}

	public static String[][] mixedColumns() {
		String[] col = new String[4];
		String[] new_col ;

		for (int i = 0; i < input.length ; i++) {
			new_col = new String[4];
			for (int j = 0; j < input.length ; j++) {
				col[j] = input[j][i];
			}
			new_col=mulCol(col);
			for (int j = 0; j < ret_matrix.length ; j++) {
				//System.out.println("col ==="+new_col[j]);
				int decimal = Integer.parseInt(new_col[j],2);
				ret_matrix[j][i] = Integer.toString(decimal,16);
			}
		}
		return ret_matrix;
	}

	public static String[] mulCol(String[] col) {

		String res_item = "",item []=new String[4],ret [] =new String[4];
		for (int i = 0; i < mix_matrix.length ; i++) {
			for (int j = 0; j < mix_matrix.length ; j++) {
				item[j]= mulItem(mix_matrix[i][j], col[j]);
				//System.out.println("///////"+item[j]);
			}
			res_item=xOR(item[0],item[1]);
			res_item=xOR(res_item, item[2]);
			res_item=xOR(res_item, item[3]);

			//System.out.println("mul ="+res_item);
			ret[i] = res_item;
			res_item="";
		}
		return ret;
	}

	public static String mulItem(String matrix_item, String col_item) {
		
		if (matrix_item.equals("01")) {
			int num = (Integer.parseInt(col_item, 16));
			String str = Integer.toBinaryString(num);
			return str;
		} else if (matrix_item.equals("02")) {
			int num = (Integer.parseInt(col_item, 16));
			String str = Integer.toBinaryString(num);
			str= checkForSize(str);
			//System.out.println(str);
			if (str.charAt(0) == '1') {
				String str1=shift(str);
				//xor
				return xOR(str1,mul_const);
			}
			else{
				String str1=shift(str);
				return str1;
				}
			}
		else if(matrix_item.equals("03")){
			int num = (Integer.parseInt(col_item, 16));
			String str = Integer.toBinaryString(num);
			str=checkForSize(str);
			if (str.charAt(0) == '1') {
				String str1 = shift(str);
				//xor
				String nstr=xOR(str1,mul_const);
				nstr=xOR(nstr,str);
				return nstr;
			}
			else{
				String str1 = shift(str);
				str1=xOR(str1, str);
				return str1;
			}
		}
		return "";
	}

	public static String shift(String str){
		String ret="";
		for (int j = 0; j < str.length(); j++) {
			if (j == str.length() -1) {
				ret += "0";
				break;
			}

			else {
				ret += str.charAt(j + 1);
			}
		}
		return ret;
	}
	
	public static String xOR(String str , String str2) {
		String ret_str="",nstr2="",nstr="";
		if(str.length() <8){
		nstr = checkForSize(str);
		}
		else if(str.length() ==8)
			nstr=str;
		//else
			//nstr=str.substring(0,8);
		//System.out.println(nstr);
		if(str2.length() < 8){
		nstr2  = checkForSize(str2);
		}
		else if(str2.length() == 8)
			nstr2=str2;
		//else
			//nstr2 = str2.substring(0,8);
		//System.out.println("///"+nstr2);
		for (int i = 0; i < nstr.length(); i++) {
			//System.out.println(str);
			if(nstr.charAt(i) == nstr2.charAt(i)){
				ret_str += "0";
			}
			else
				ret_str +="1";
		}
		//System.out.println(ret_str);
		return ret_str;
	}
	
	public static String checkForSize(String str){
		if(str.length() <8){
			String ret_str=str;
			for (int i = 0; i < 8-str.length(); i++) {
				ret_str = "0"+ret_str;
			}
			return ret_str;
		}
		else
			return str;
	}
}
