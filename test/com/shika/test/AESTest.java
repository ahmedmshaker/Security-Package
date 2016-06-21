package com.shika.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.AES.Decryption;
import com.AES.Encryption;

public class AESTest {

	String mainPlain = "3243F6A8885A308D313198A2e0370734";
	String mainCipher = "3925841D02DC09FBDC118597196A0B32";
	String mainKey = "2B7E151628AED2A6ABF7158809CF4F3C";

	String mainPlain2 = "00000000000000000000000000000001";
	String mainCipher2 = "58e2fccefa7e3061367f1d57a4e7455a";
	String mainKey2 = "00000000000000000000000000000000";

	String mainPlain3 = "00112233445566778899aabbccddeeff";
	String mainCipher3 = "69c4e0d86a7b0430d8cdb78070b4c55a";
	String mainKey3 = "000102030405060708090a0b0c0d0e0f";

	@Test
	public void AESTestEnc1() throws IOException {
		String cipher= new Encryption(mainPlain ,mainKey).encryption();
		 
		assertTrue(cipher.equals(mainCipher.toLowerCase()));
	}

	@Test
	public void AESTestDec1() throws IOException {
		String plain= new Decryption(mainCipher ,mainKey).decryption();
		
		assertTrue(plain.equals(mainPlain.toLowerCase()));
	}

	@Test
	public void AESTestEnc2() throws IOException {
		Encryption algorithm = new Encryption(mainPlain2 ,mainKey2);
		String cipher = algorithm.encryption();
		System.out.println(cipher);
		assertTrue(cipher.equals(mainCipher2));
	}

	@Test
	public void AESTestDec2() throws IOException {
		Decryption algorithm = new Decryption(mainCipher2 ,mainKey2);
		String plain = algorithm.decryption();
		assertTrue(plain.equals(mainPlain2));
	}

	@Test
	public void AESTestEnc3() throws IOException {
		Encryption algorithm = new Encryption(mainPlain3 ,mainKey3);
		String cipher = algorithm.encryption();
		assertTrue(cipher.equals(mainCipher3));
	}

	@Test
	public void AESTestDec3() throws IOException {
		Decryption algorithm = new Decryption(mainCipher3 ,mainKey3);
		String plain = algorithm.decryption();
		assertTrue(plain.equals(mainPlain3));
	}
}
