package com.shika.security;

public class HillCipher {

	private int[] subMatrix;
	int key[][];
	String Encraption = "";
	int[] resultMatrix;

	private void divideTheStatment(String statment, int m) {

		statment = statment.replaceAll("\\s", "");

		while (statment.length() > m) {
			String sub = statment.substring(0, m);
			statment = statment.substring(m, statment.length());
			perform(sub);

		}
		if (statment.length() == m) {
			perform(statment);
		} else if (statment.length() < m) {
			for (int i = statment.length(); i < m; i++) {
				statment = statment + 'x';
			}
			perform(statment);
		}

	}

	/*
	 * public static int determinant(int a[][], int n){ int det = 0, sign = 1, p
	 * = 0, q = 0;
	 * 
	 * if(n==1){ det = a[0][0]; } else{ int b[][] = new int[n-1][n-1]; for(int x
	 * = 0 ; x < n ; x++){ p=0;q=0; for(int i = 1;i < n; i++){ for(int j = 0; j
	 * < n;j++){ if(j != x){ b[p][q++] = a[i][j]; if(q % (n-1) == 0){ p++; q=0;
	 * } } } } det = det + a[0][x] * determinant(b, n-1) * sign; sign = -sign; }
	 * } return det; }
	 */

	public static int[][] cofactor(int[][] matrix) {
		int[][] mat = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				mat[i][j] = changeSign(i) * changeSign(j)
						* determinant(createSubMatrix(matrix, i, j));
			}
		}

		return mat;
	}

	public static int[][] createSubMatrix(int[][] matrix, int excluding_row,
			int excluding_col) {
		int[][] mat = new int[matrix.length - 1][matrix[0].length - 1];
		int r = -1;
		for (int i = 0; i < matrix.length; i++) {
			if (i == excluding_row)
				continue;
			r++;
			int c = -1;
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == excluding_col)
					continue;
				mat[r][++c] = matrix[i][j];

			}
		}
		return mat;
	}

	public static int determinant(int[][] matrix) {
		if (matrix.length != matrix[0].length)
			return 0;
		if (matrix.length == 1) {
			return matrix[0][0];
		}

		if (matrix.length == 2) {
			return (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
		}
		int sum = 0;
		for (int i = 0; i < matrix[0].length; i++) {
			sum += changeSign(i) * matrix[0][i]
					* determinant(createSubMatrix(matrix, 0, i));
		}
		return sum;
	}

	private void perform(String sub) {
		lineToInt(sub);
		multiplayWithKey(sub.length());
		result(sub.length());
	}

	private void lineToInt(String sub) {
		subMatrix = new int[sub.length()];

		for (int i = 0; i < sub.length(); i++) {
			subMatrix[i] = sub.charAt(i) - 97;
		}
	}

	private int[][] stringToMatrix(String KeyString, int m) {
		key = new int[m][m];
		int x = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				key[i][j] = (int) KeyString.charAt(x) - 97;
				x++;
			}
		}
		return key;
	}

	private void multiplayWithKey(int length) {
		resultMatrix = new int[length];
		for (int i = 0; i < length; i++) {
			resultMatrix[i] = 0;
			for (int j = 0; j < length; j++) {
				resultMatrix[i] += key[i][j] * subMatrix[j];
				// System.out.println(subMatrix[j]);
			}

			resultMatrix[i] %= 26;
			// System.out.println(resultMatrix[i]);
		}
	}

	private void result(int length) {

		for (int i = 0; i < length; i++) {
			Encraption += (char) (resultMatrix[i] + 97);
		}
	}

	private int modular(int determinant) {
		if (determinant % 26 < 0) {
			return (determinant % 26) + 26;
		}
		return determinant % 26;
	}

	private int modInverse(int a, int m) {
		a %= m;
		for (int x = 1; x < m; x++) {
			if ((a * x) % m == 1)
				return x;
		}
		return 0;
	}

	private static int changeSign(int i) {
		if (i % 2 == 0)
			return 1;
		return -1;
	}

	public String encrypt(String statment, String keyString) throws Exception {
		double k = Math.sqrt(keyString.length());
		int m = (int) k;
		if (k == m) {
			stringToMatrix(keyString, m);
			divideTheStatment(statment, m);
			return Encraption;
		} else {
			throw new Exception("please enter correct key because key not valid , key must be "
					+ m * m);
		}

	}

	private int[][] performDecryption(int length, int[][] x) throws Exception {
		int[][] mat = cofactor(x);
		int[][] matrix = new int[x[0].length][x.length];
		int modularInverse = modInverse(modular(determinant(x)), 26);
		if (modularInverse==0) {
			throw new Exception("dosn't have modular inverse");
		}else{
		System.out.println(modularInverse);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				//System.out.print(modular(mat[i][j]) + " ");
				matrix[j][i] = modular((int) (modularInverse * modular(mat[i][j])));
			}
			System.out.println();
		}
		return matrix;
		}

	}

	/*
	 * public static int[][] transpose(int[][] matrix) { int[][]
	 * transposedMatrix = new int[matrix.length][matrix[0].length]; for (int
	 * i=0;i<matrix.length;i++) { for (int j=0;j<matrix[0].length;j++) {
	 * transposedMatrix[j][i]= matrix[i][j]; } } return transposedMatrix; }
	 */
	public String decrypt(String Cipher, String keyString) throws Exception {
		double k = Math.sqrt(keyString.length());
		int m = (int) k;
		if (k == m) {

			stringToMatrix(keyString, m);
			key = performDecryption(m, key);
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key[0].length; j++) {
					System.out.print(key[i][j] + " ");
				}
				System.out.println();
			}
			divideTheStatment(Cipher, m);
			return Encraption;
		} else {
			throw new Exception("please enter correct key because key not valid , key must be "
					+ m * m);
		}

	}

	private int[][] multiplayTowMatrix(int[][] a, int[][] b) {
		int[][] res = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					res[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return res;
	}

	private String MatrixToString(int[][] res) {
		Encraption = "";
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				Encraption += (char) (res[i][j] + 97);
			}

		}
		return Encraption;
	}

	public String Cryptanalysis(String plain, String cipher, int m) throws Exception {

		int[][] p = stringToMatrix(plain.replaceAll("\\s", "").toLowerCase(), m);
		int[][] c = stringToMatrix(cipher.replaceAll("\\s", "").toLowerCase(),
				m);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] pInverse;
		try {
			pInverse = performDecryption(m, p);
		} catch (Exception e) {
				String sub = plain.substring(m ,m+m);
				plain= plain.replaceAll(sub, "");
				String sub1 = cipher.substring(m ,m+m);
				cipher= cipher.replaceAll(sub1, "");
				System.out.println(plain + "     "+cipher);
				p = stringToMatrix(plain.replaceAll("\\s", "").toLowerCase(), m);
				c = stringToMatrix(cipher.replaceAll("\\s", "").toLowerCase(),
						m);
				pInverse = performDecryption(m, p);
			
		}

		int[][] result = multiplayTowMatrix(pInverse,c);
		
		
		for (int i = 0; i < pInverse.length; i++) {
			for (int j = 0; j < pInverse[0].length; j++) {
				System.out.print(pInverse[i][j] + " ");
			}
			System.out.println();
		}
		return MatrixToString(result);

	}
	
	
}
