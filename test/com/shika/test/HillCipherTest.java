package com.shika.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shika.security.HillCipher;

public class HillCipherTest {
	String mainPlain = "paymoremoney";
	String mainCipher = "tqssypkoqviw";
	String mainKey = "dcif";

	String keyS3 = "rrfvsvcct";
	String cipherS3 = "lnshdlewmtrw";

	String mainPlain3 = "fvcfcqtob";
	String mainCipher3 = "hgrzeudvq";
	String mainKey3 = "bkaaubcpc";
	String mainPlainError = "lkdi".toLowerCase();
	String mainCipherError = "njjv".toLowerCase();

	String keyError = "lkdi";

	String newPlain = "thegoldisburiedinorono".toLowerCase();
	String newCipher = "gzscxnvcdjzxeovcrclsrc".toLowerCase();
	String newKey = "frep";

	@Test
	public void HillCipherTest1() throws Exception {
		HillCipher algorithm = new HillCipher();
		String cipher = algorithm.encrypt(mainPlain, mainKey);
		assertTrue(cipher.equals(mainCipher));
	}

	@Test
	public void HillCipherTest2() throws Exception {
		HillCipher algorithm = new HillCipher();
		String plain = algorithm.decrypt(mainCipher, mainKey);
		assertTrue(plain.equals(mainPlain));
	}
	@Test
	public void HillCipherTest16() throws Exception {
		HillCipher algorithm = new HillCipher();
		String plain = algorithm.Cryptanalysis(mainPlain, mainCipher, 2);
		assertTrue(plain.equals(mainKey));
	}

	@Test
	public void HillCipherTest4() throws Exception {
		HillCipher algorithm = new HillCipher();
		String cipher = algorithm.encrypt(mainPlain, keyS3);
		assertTrue(cipher.equals(cipherS3));
	}

	@Test
	public void HillCipherTest5() throws Exception {
		HillCipher algorithm = new HillCipher();
		String plain = algorithm.decrypt(cipherS3, keyS3);
		assertTrue(plain.equals(mainPlain));
	}

	@Test
	public void HillCipherTest6() throws Exception {
		HillCipher algorithm = new HillCipher();
		String cipher = algorithm.encrypt(mainPlain3, mainKey3);
		assertTrue(cipher.equals(mainCipher3));
	}

	@Test
	public void HillCipherTest7() throws Exception {
		HillCipher algorithm = new HillCipher();
		String plain = algorithm.decrypt(mainCipher3, mainKey3);
		assertTrue(plain.equals(mainPlain3));
	}

	@Test
	public void HillCipherTest8() throws Exception {
		HillCipher algorithm = new HillCipher();
		String cipher = algorithm.encrypt(newPlain, newKey);
		assertTrue(cipher.equals(newCipher));
	}

	@Test
	public void HillCipherTest9() throws Exception {
		HillCipher algorithm = new HillCipher();
		String plain = algorithm.decrypt(newCipher, newKey);
		assertTrue(plain.equals(newPlain));
	}

	@Test
	public void HillCipherTestEnc10() throws Exception {
		HillCipher algorithm = new HillCipher();
		String cipher = algorithm.encrypt(mainPlain3, mainKey3);
		assertTrue(cipher.equals(mainCipher3));
	}

	@Test
	public void HillCipherTestDec12() throws Exception {
		HillCipher algorithm = new HillCipher();
		String plain = algorithm.decrypt(mainCipher3, mainKey3);
		assertTrue(plain.equals(mainPlain3));
	}
	@Test
	public void HillCipherTestEnc13() throws Exception {
		HillCipher algorithm = new HillCipher();
		String cipher = algorithm.encrypt(mainPlainError, keyError);
		assertTrue(cipher.equals(mainCipherError));
	}

	@Test
	public void HillCipherTestDec14() {
		HillCipher algorithm = new HillCipher();
		try {
			String plain = algorithm.decrypt(mainPlain, keyError);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void HillCipherTestDec15() {
		HillCipher algorithm = new HillCipher();
		try {
			String plain = algorithm.encrypt(mainPlainError, keyError);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void HillCipherTestDec16() {
		HillCipher algorithm = new HillCipher();
		try {
			String plain = algorithm.decrypt(mainCipherError, keyError);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
