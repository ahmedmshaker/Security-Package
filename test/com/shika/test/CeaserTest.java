package com.shika.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.shika.security.Ceaser;


public class CeaserTest {
	String mainPlain = "meetmeaftertheparty";
    String mainCipher = "phhwphdiwhuwkhsduwb";
    int mainKey = 3;

    String mainPlain1 = "defendtheeastwallofthecastle";
    String mainCipher1 = "defendtheeastwallofthecastle";
    int mainKey1 = 0;

    String mainPlain2 = "defendtheeastwallofthecastle";
    String mainCipher2 = "bcdclbrfccyqruyjjmdrfcayqrjc";
    int mainKey2 = 24;
    
    String newPlain = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG".toLowerCase();
    String newCipher = "WKHTXLFNEURZQIRAMXPSVRYHUWKHODCBGRJ".toLowerCase();
    int newKey = 3;

	@Test
	public void CeaserTest1() {
		Ceaser ceaser = new Ceaser();
		String cipher = ceaser.encrypt(mainPlain, mainKey);
		assertEquals(cipher, mainCipher);
	}

	@Test
	public void CeaserTest2() {
		Ceaser ceaser = new Ceaser();
		String plain = ceaser.decrypt(mainCipher, mainKey);
		assertEquals(plain, mainPlain);
	}
	@Test
	public void CeaserTest3() {
		Ceaser ceaser = new Ceaser();
		int key = ceaser.cryptanalysis(mainPlain, mainCipher);
		assertEquals(key, mainKey);
	}
	@Test
	public void CeaserTest4() {
		Ceaser ceaser = new Ceaser();
		String cipher = ceaser.encrypt(mainPlain1, mainKey1);
		assertEquals(cipher, mainCipher1);
	}

	@Test
	public void CeaserTest5() {
		Ceaser ceaser = new Ceaser();
		String plain = ceaser.decrypt(mainCipher1, mainKey1);
		assertEquals(plain, mainPlain1);
	}
	@Test
	public void CeaserTest6() {
		Ceaser ceaser = new Ceaser();
		int key = ceaser.cryptanalysis(mainPlain1, mainCipher1);
		assertEquals(key, mainKey1);
	}
	
	@Test
	public void CeaserTest7() {
		Ceaser ceaser = new Ceaser();
		String cipher = ceaser.encrypt(mainPlain2, mainKey2);
		assertEquals(cipher, mainCipher2);
	}

	@Test
	public void CeaserTest8() {
		Ceaser ceaser = new Ceaser();
		String plain = ceaser.decrypt(mainCipher2, mainKey2);
		assertEquals(plain, mainPlain2);
	}
	@Test
	public void CeaserTest9() {
		Ceaser ceaser = new Ceaser();
		int key = ceaser.cryptanalysis(mainPlain2, mainCipher2);
		assertEquals(key, mainKey2);
	}
	@Test
	public void CeaserTest10() {
		Ceaser ceaser = new Ceaser();
		String cipher = ceaser.encrypt(newPlain, newKey);
		assertEquals(cipher, newCipher);
	}

	@Test
	public void CeaserTest11() {
		Ceaser ceaser = new Ceaser();
		String plain = ceaser.decrypt(newCipher, newKey);
		assertEquals(plain, newPlain);
	}
	@Test
	public void CeaserTest12() {
		Ceaser ceaser = new Ceaser();
		int key = ceaser.cryptanalysis(newPlain, newCipher);
		assertEquals(key, newKey);
	}
	
	
}
