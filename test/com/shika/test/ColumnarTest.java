package com.shika.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shika.security.Columnar;

public class ColumnarTest {
	
	 String mainPlain1 = "attachpostponeduntiltwoam";
     String mainPlain2 = "attachpostponeduntiltwoamxxx";
     String mainCipher1 = "ttnaaptmtsuoaodwcoixhnlxpetx";
     String mainCipher2 = "ttnaaptmtsuoaodwcoihnlpet";
     
     String key = "4312567";
     

     String mainPlain3 = "computerscience";
     String mainPlain4 = "computersciencex";

     String mainCipher3 = "ctipscoeemrnuce";
     String mainCipher4 = "cusnpremeieotcc";
     String mainCipher5 = "cusnprexmeieotcc";

     String mainkey1 ="13425";
     String mainkey2 ="1432";
     String newPlain = "defendtheeastwallofthecastleee";
     String newCipher = "nalceehwttdttfseeleedsoaefeahl";
     
     String newKey = "326415";

	@Test
	public void ColumnarTest1() {
		Columnar algorithm = new Columnar();
		String cipher = algorithm.encrypt(mainPlain2, key);
		assertEquals(cipher, mainCipher1);
	}
	@Test
	public void ColumnarTest2() {
		Columnar algorithm = new Columnar();
		String plain = algorithm.decrypt(mainCipher1, key);
		System.out.println(plain);
		assertEquals(plain, mainPlain2);
	}
	@Test
	public void ColumnarTest3() {
		Columnar algorithm = new Columnar();
		String mKey = algorithm.analysis(mainPlain2, mainCipher1);
		System.out.println(mKey);
		assertEquals(key, mKey);
	}
	public void ColumnarTest4() {
		Columnar algorithm = new Columnar();
		String cipher = algorithm.encrypt(mainPlain4, mainkey1);
		assertEquals(cipher, mainCipher4);
	}
	@Test
	public void ColumnarTest5() {
		Columnar algorithm = new Columnar();
		String plain = algorithm.decrypt(mainCipher3, mainkey1);
		System.out.println(plain);
		assertEquals(plain, mainPlain3);
	}
	@Test
	public void ColumnarTest6() {
		Columnar algorithm = new Columnar();
		String mKey = algorithm.analysis(mainPlain3, mainCipher3);
		System.out.println(mKey);
		assertEquals(mainkey1, mKey);
	}
	public void ColumnarTest7() {
		Columnar algorithm = new Columnar();
		String cipher = algorithm.encrypt(mainPlain4, mainkey2);
		assertEquals(cipher, mainCipher1);
	}
	@Test
	public void ColumnarTest8() {
		Columnar algorithm = new Columnar();
		String plain = algorithm.decrypt(mainCipher1, key);
		System.out.println(plain);
		assertEquals(plain, mainPlain2);
	}
	@Test
	public void ColumnarTest9() {
		Columnar algorithm = new Columnar();
		String mKey = algorithm.analysis(mainPlain4, mainCipher5);
		System.out.println(mKey);
		assertEquals(mainkey2, mKey);
	}
	

	public void ColumnarTest10() {
		Columnar algorithm = new Columnar();
		String cipher = algorithm.encrypt(newPlain, newKey);
		assertEquals(cipher, newCipher);
	}
	@Test
	public void ColumnarTest11() {
		Columnar algorithm = new Columnar();
		String plain = algorithm.decrypt(newCipher, newKey);
		System.out.println(plain);
		assertEquals(plain, newPlain);
	}
	@Test
	public void ColumnarTest12() {
		Columnar algorithm = new Columnar();
		String mKey = algorithm.analysis(newPlain, newCipher);
		System.out.println(mKey);
		assertEquals(newKey, mKey);
	}

}
