package com.shika.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.shika.security.RSA;

public class RSATest {

	@Test
	public void RSATest1() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.encrypt(new BigInteger("11"), new BigInteger("17"), new BigInteger("88") , new BigInteger("7"));
		assertEquals(b, new BigInteger("11"));
	}

	@Test
	public void RSATest2() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.decrypt(new BigInteger("11"), new BigInteger("17"), new BigInteger("11") , new BigInteger("7"));
		assertEquals(b, new BigInteger("88"));
	}
	@Test
	public void RSATest3() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.encrypt(new BigInteger("13"), new BigInteger("19"), new BigInteger("65") , new BigInteger("5"));
		assertEquals(b, new BigInteger("221"));
	}
	@Test
	public void RSATest4() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.decrypt(new BigInteger("13"), new BigInteger("19"), new BigInteger("221") , new BigInteger("5"));
		assertEquals(b, new BigInteger("65"));
	}
	@Test
	public void RSATest5() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.encrypt(new BigInteger("61"), new BigInteger("53"), new BigInteger("70") , new BigInteger("7"));
		assertEquals(b, new BigInteger("2338"));
	}
	@Test
	public void RSATest6() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.decrypt(new BigInteger("61"), new BigInteger("53"), new BigInteger("2338") , new BigInteger("7"));
		assertEquals(b, new BigInteger("70"));
	}
	
	@Test
	public void RSATest7() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.encrypt(new BigInteger("257"), new BigInteger("337"), new BigInteger("18537") , new BigInteger("17"));
		assertEquals(b, new BigInteger("12448"));
	}
	
	@Test
	public void RSATest8() throws Exception {
		RSA algorithm = new RSA();
		BigInteger b = algorithm.decrypt(new BigInteger("257"), new BigInteger("337"), new BigInteger("12448") , new BigInteger("17"));
		assertEquals(b, new BigInteger("18537"));
	}
	
}
