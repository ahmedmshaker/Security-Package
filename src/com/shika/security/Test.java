package com.shika.security;


public class Test {

	/**
	 * @param args
	 * @throws Exception
	 * @throws NoSquareException
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// System.out.println(hill.encrapte("Please enter the name of the file storing the key".toLowerCase(),
		// "rrfvsvcct" , 3));
		// String st = "pay more money";
		/*
		 * Matrix matrix = new Matrix(new double[][]{{17,17 , 5},{21,18,21}
		 * ,{2,2,19}});
		 * //System.out.println(MatrixMathematics.determinant(matrix)); matrix =
		 * MatrixMathematics.inverse(matrix);
		 * System.out.println((matrix.getValueAt(0, 0)*26+8)*26);
		 * System.out.println(MatrixMathematics.determinant(new int[][]{{17,17 ,
		 * 5},{21,18,21} ,{2,2,19}}, 3)%26);
		 */
		/*String mainPlainError = "lkdi".toLowerCase();
		String mainCipherError = "SDEK".toLowerCase();

		String keyError = "lkdi";

		HillCipher hill = new HillCipher();
		System.out.println(hill.encrypt(mainPlainError, keyError));
		
		/*String newPlain = "defendtheeastwallofthecastleee";
	     String newCipher = "nalceehwttdttfseeleedsoaefeahl";
	     
	     String newKey = "326415";
	     Columnar c = new Columnar();
	     System.out.println(c.analysis(newPlain, newCipher));
		
		// hillcipher c = new hillcipher();
		/*String mainPlain = "meetmeaftertheparty";
	    String mainCipher = "mematrhpryetefeteat";
	    
	    
	    RailFence r = new RailFence();
	    r.cryptanalysis(mainPlain, mainCipher);
		/*
		 * System.out.println(c.determinant(new int[][]{{17,17 , 5},{21,18,21}
		 * ,{2,2,19}}, 3)); if (c.check("rrfvsvcct", 3)) {
		 * System.out.println("Result:");
		 * c.divide("Please enter the name of the file storing the key", 3);
		 * c.cofact(c.keymatrix, 3); }
		 */
		// c.cofact(new int[][]{{17,17 , 5},{21,18,21} ,{2,2,19}}, 3);

		// System.out.println(modInverse(23, 26));

		/*
		 * int[][] x = HillCipher.cofactor(new int[][]{{17,17 , 5},{21,18,21}
		 * ,{2,2,19}});
		 * System.out.println(hill.modularDeterminant(HillCipher.determinant(new
		 * int[][]{{17,17 , 5},{21,18,21} ,{2,2,19}})));
		 */
		// System.out.println(Math.abs(-6));
		// System.out.println( hill.Cryptanalysis("pay more money",
		// "LNS HDL EWM TRW".toLowerCase(), 3));

		/*
		 * RailFence algorithm = new RailFence(); //String plain1 =
		 * algorithm.decryption(mainCipher2, mainKey2); String plain2 =
		 * algorithm.decryption("mtaehayemfrereettpt", 3);
		 * System.out.println(plain2); /*Columnar algorithm = new Columnar();
		 * System.out.println(algorithm.encrypt("attachpostponeduntiltwoam",
		 * "4312567")); /*RSA r = new RSA(); System.out.println(r.decryption(new
		 * BigInteger("11"),new BigInteger("17") , new BigInteger("44")));
		 */

		/*RC4 r = new RC4();
		System.out.println(r.decrypt("abcd", "test"));
		System.out.println(Integer.toHexString(Integer.parseInt("15", 16)
				^ Integer.parseInt("74", 16)));

		System.out.println((char) 207);
		// System.out.println(Integer.parseInt("1f"));

		// System.out.println("hello world");
		/*
		 * System.out.println(261%26); System.out.println(180%26);
		 * 
		 * HillCipher hi = new HillCipher(); System.out.println(); String
		 * mainPlain = "paym"; String mainCipher = "tqss";
		 * System.out.println(hi.Cryptanalysis(mainPlain, mainCipher, 2));
		 */
	    
	     /*
	     
	     Columnar col= new Columnar();
	     System.out.println(col.analysis(mainPlain2, mainCipher1));*/
		HillCipher h = new HillCipher();
		System.out.println(h.Cryptanalysis("friday", "pqcfku", 2));

	}

}
