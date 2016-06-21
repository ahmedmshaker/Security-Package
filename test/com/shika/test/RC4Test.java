package com.shika.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shika.security.RC4;

public class RC4Test {

	@Test
	public void RC4Test1() {
		RC4 algorithm = new RC4();
		String cipher = algorithm.encrypt("abcd", "test");
		assertTrue(cipher.equals("ÏíDu"));
	}

	@Test
	public void RC4Test2() {
		RC4 algorithm = new RC4();
		String cipher = algorithm.decrypt("ÏíDu", "test");
		assertTrue(cipher.equals("abcd"));
	}
	@Test
	public void RC4Test3() {
		RC4 algorithm = new RC4();
		String cipher = algorithm.encrypt("aaaa", "test");
		assertTrue(cipher.equals("ÏîFp"));
	}

	@Test
	public void RC4Test4() {
		RC4 algorithm = new RC4();
		String cipher = algorithm.decrypt("ÏîFp", "test");
		assertTrue(cipher.equals("aaaa"));
	}

    
}
