package com.shika.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shika.security.Euclidean;

public class EuclideanTest {

	@Test
	public void ExtendedEuclidTest1() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(23, 26);
		assertEquals(res, 17);
	}

	@Test
	public void ExtendedEuclidTest2() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(22, 26);
		assertEquals(res, -1);
	}

	@Test
	public void ExtendedEuclidTest3() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(50, 71);
		assertEquals(res, 27);
	}

	@Test
	public void ExtendedEuclidTest4() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(43, 64);
		assertEquals(res, 3);
	}

	@Test
	public void ExtendedEuclidTest5() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(1111, 22222);
		assertEquals(res, 11101);
	}

	@Test
	public void ExtendedEuclidTest6() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(123456789, 1236);
		assertEquals(res, -1);
	}

	@Test
	public void ExtendedEuclidTes7() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(123456789, 12365);
		assertEquals(res, 3729);
	}

	@Test
	public void ExtendedEuclidNewTest() {
		Euclidean algorithm = new Euclidean();
		int res = algorithm.GetMultiplicativeInverse(13245687, 135469);
		assertEquals(res, 38164);
	}
}
