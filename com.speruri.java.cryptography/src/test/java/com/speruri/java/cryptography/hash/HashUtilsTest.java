package com.speruri.java.cryptography.hash;

import javax.xml.bind.DatatypeConverter;

import org.junit.Assert;
import org.junit.Test;

public class HashUtilsTest {

	@Test
	public void test() throws Exception {
		byte[] randomSalt = HashUtils.generateRandomSalt();
		String input = "This is Srikanth Peruri";
		byte[] sha2Hash = HashUtils.createSHA2Hash(input, randomSalt);
		Assert.assertNotNull(sha2Hash);
		System.out.println("SHA2 generated is " + DatatypeConverter.printHexBinary(sha2Hash));
	}

	@Test
	public void testHashPassword() {
		String password = "JyoSrikanthPeruri";
		String hashPassword = HashUtils.hashPassword(password);
		System.out.println("Hashed pwd : " + hashPassword);
		boolean verifyPassword = HashUtils.verifyPassword(password, hashPassword);
		System.out.println(verifyPassword);
		Assert.assertEquals(verifyPassword, true);
	}

}
