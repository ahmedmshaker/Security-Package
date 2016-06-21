package com.shika.security;

import java.math.BigInteger;

public class RSA {

	private boolean isPrime(BigInteger num) {
		if (!num.isProbablePrime(-1))
			return false;
		return true;
	}

	private BigInteger calculateN(BigInteger p, BigInteger q) {
		return p.multiply(q);
	}

	private BigInteger fiOfN(BigInteger p, BigInteger q) {
		return (p.subtract(new BigInteger("1"))).multiply((q
				.subtract(new BigInteger("1"))));
	}

	private boolean GCD(BigInteger e, BigInteger citaofN) {
		if (citaofN.gcd(e).equals(new BigInteger("1"))) {
			return true;
		}
		return false;
	}

	private BigInteger calculateD(BigInteger e, BigInteger citaofN) {
		return e.modInverse(citaofN);
	}
	/*private BigInteger calculateE(BigInteger fiOfN) throws Exception{
		BigInteger e = new BigInteger("2");
		for (int i = 0; i < fiOfN.longValue(); i++) {
			if (!fiOfN.gcd(new BigInteger(e + "")).equals(new BigInteger("1"))) {
				e = e.add(BigInteger.ONE);
			}else {
				return e;
			}
		}
		throw new Exception("can't find gcd of e");
	}
*/
	public BigInteger encrypt(BigInteger p, BigInteger q,
			BigInteger m , BigInteger e) throws Exception {
		if (isPrime(p) && isPrime(q)) {
			BigInteger n = calculateN(p, q);
			BigInteger citaofN = fiOfN(p, q);
			if (GCD(e, citaofN)) {
				return (m.pow(e.intValue())).mod(n);
			}
		}

		throw new Exception(
				"gcd e and citaOf n must be 1 or p and q must be prime");
	}

	public BigInteger decrypt(BigInteger p, BigInteger q,BigInteger c , BigInteger e)
			throws Exception {
		if (isPrime(p) && isPrime(q)) {

			BigInteger citaofN = fiOfN(p, q);
			System.out.println(e);
			BigInteger d = calculateD(e, citaofN);
			System.out.println(d);
			BigInteger n = calculateN(p, q);
			if (GCD(e, citaofN)) {
				return (c.pow(d.intValue())).mod(n);
			}
		}

		throw new Exception(
				"gcd e and citaOf n must be 1 or p and q must be prime");
	}

}
