package com.shika.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shika.security.RailFence;

public class RailFenceTest {
	
	String mainPlain1 = "meetmeaftertheparty";
    String mainPlain2 = "meetmeafterthepartyxx";

    String mainCipher = "mematrhpryetefeteat";

    String mainCipher2 = "mtaehayemfrereettpt";
    String mainCipher3 = "mtaehayemfrerxeettptx";

    int mainKey = 2;
    int mainKey2 = 3;

    String newPlain = "nothingisasitseems".toLowerCase();
    String newCipher = "NTIGSSTEMOHNIAISES".toLowerCase();
    int newkey = 2;


	@Test
	public void RailFenceTest1() {
		RailFence algorithm = new RailFence();
		String cipher = algorithm.encrypt(mainPlain1, mainKey);
		assertEquals(cipher, mainCipher);
	}
	@Test
	public void RailFenceTest2() {
		RailFence algorithm = new RailFence();
		String plain = algorithm.decrypt(mainCipher, mainKey);
		assertEquals(plain, mainPlain1);
	}
	@Test
	public void RailFenceTest3() {
		RailFence algorithm = new RailFence();
		int key = algorithm.cryptanalysis(mainPlain1, mainCipher);
		assertEquals(key, mainKey);
	}

	@Test
	public void RailFenceTest4() {
		RailFence algorithm = new RailFence();
		String cipher = algorithm.encrypt(mainPlain1, mainKey2);
		assertTrue(cipher.equals(mainCipher2)||cipher.equals(mainCipher3));
	}
	@Test
	public void RailFenceTest5() {
		RailFence algorithm = new RailFence();
		//String plain1 = algorithm.decryption(mainCipher2, mainKey2);
		String plain2 = algorithm.decrypt(mainCipher3, mainKey2);
		assertTrue(plain2.equals(mainPlain1));
	}
	@Test
	public void RailFenceTest6() {
		RailFence algorithm = new RailFence();
		int key = algorithm.cryptanalysis(mainPlain2, mainCipher3);
		assertEquals(key, mainKey2);
	}
	@Test
	public void RailFenceTest7() {
		RailFence algorithm = new RailFence();
		String cipher = algorithm.encrypt(newPlain, newkey);
		assertTrue(cipher.equals(newCipher));
	}
	@Test
	public void RailFenceTest8() {
		RailFence algorithm = new RailFence();
		//String plain1 = algorithm.decryption(mainCipher2, mainKey2);
		String plain2 = algorithm.decrypt(newCipher, newkey);
		assertTrue(plain2.equals(newPlain));
	}
	@Test
	public void RailFenceTest9() {
		RailFence algorithm = new RailFence();
		int key = algorithm.cryptanalysis(newPlain, newCipher);
		assertEquals(key, newkey);
	}
	
}
