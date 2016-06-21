package com.AES;
public class Inv_MixColumns {

	public static String[][] inv_matrix = { { "0E", "0B", "0D", "09" },
			{ "09", "0E", "0B", "0D" }, { "0D", "09", "0E", "0B" },
			{ "0B", "0D", "09", "0E" } };
	static String[][] input;
	static String[][] ret_matrix = new String[4][4];
	static final String mul_const = "00011011";

	public Inv_MixColumns(String[][] input) {
		this.input = input;
	}

	public static String[][] inversedColumns() {
		String[] col = new String[4];
		String[] new_col;

		for (int i = 0; i < input.length; i++) {
			new_col = new String[4];
			for (int j = 0; j < input.length; j++) {
				col[j] = input[j][i];
			}
			new_col = mulCol(col);
			for (int j = 0; j < ret_matrix.length; j++) {
				// System.out.println("col ==="+new_col[j]);
				int decimal = Integer.parseInt(new_col[j], 2);
				ret_matrix[j][i] = Integer.toString(decimal, 16);
			}
		}
		return ret_matrix;
	}

	public static String[] mulCol(String[] col) {

		String res_item = "", item[] = new String[4], ret[] = new String[4];
		for (int i = 0; i < inv_matrix.length; i++) {
			for (int j = 0; j < inv_matrix.length; j++) {
				item[j] = mulItem(inv_matrix[i][j], col[j]);
				// System.out.println("///////"+item[j]);
			}
			res_item = MixColumns.xOR(item[0], item[1]);
			res_item = MixColumns.xOR(res_item, item[2]);
			res_item = MixColumns.xOR(res_item, item[3]);

			// System.out.println("mul ="+res_item);
			ret[i] = res_item;
			res_item = "";
		}
		return ret;
	}

	public static String mulItem(String matrix_item, String col_item) {

		String mul_by_x,mul_by_x2,mul_by_x3,ret_str="";
		

		if (matrix_item.equals("0E")) {
			int num = (Integer.parseInt(col_item, 16));
			String str = Integer.toBinaryString(num);
			//mul * x
			mul_by_x = mul_x(str);
			//mul * x^2
			mul_by_x2 = mul_x(str);
			mul_by_x2 = mul_x(mul_by_x2);
			//mul * x^3
			mul_by_x3 = mul_x(str);
			mul_by_x3 = mul_x(mul_by_x3);
			mul_by_x3 = mul_x(mul_by_x3);

			ret_str = MixColumns.xOR(mul_by_x, mul_by_x2);
			ret_str= MixColumns.xOR(ret_str, mul_by_x3);
			
		}
		else if (matrix_item.equals("0B")) {
			int num = (Integer.parseInt(col_item, 16));
			String str = Integer.toBinaryString(num);
			//mul * x
			mul_by_x = mul_x(str);
			//mul * x^3
			mul_by_x3 = mul_x(str);
			mul_by_x3 = mul_x(mul_by_x3);
			mul_by_x3 = mul_x(mul_by_x3);

			ret_str = MixColumns.xOR(mul_by_x, str);
			ret_str= MixColumns.xOR(ret_str, mul_by_x3);
			
		}

		else if (matrix_item.equals("0D")) {
			int num = (Integer.parseInt(col_item, 16));
			String str = Integer.toBinaryString(num);
			//mul * x^2
			mul_by_x2 = mul_x(str);
			mul_by_x2 = mul_x(mul_by_x2);
			//mul * x^3
			mul_by_x3 = mul_x(str);
			mul_by_x3 = mul_x(mul_by_x3);
			mul_by_x3 = mul_x(mul_by_x3);

			ret_str = MixColumns.xOR(mul_by_x2,str);
			ret_str= MixColumns.xOR(ret_str, mul_by_x3);
			
		}
		else if (matrix_item.equals("09")) {
			int num = (Integer.parseInt(col_item, 16));
			String str = Integer.toBinaryString(num);
			//mul * x^3
			mul_by_x3 = mul_x(str);
			mul_by_x3 = mul_x(mul_by_x3);
			mul_by_x3 = mul_x(mul_by_x3);

			ret_str = MixColumns.xOR(mul_by_x3, str);
			
		}
		return ret_str;

	}

	public static String mul_x(String item) {
		
		item= MixColumns.checkForSize(item);
		if (item.charAt(0) == '1') {
			String str1=MixColumns.shift(item);
			//xor
			return MixColumns.xOR(str1,mul_const);
		}
		else{
			String str1=MixColumns.shift(item);
			return str1;
			}
		}
		
	
}
