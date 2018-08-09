package com.speruri.java.cryptography.symmetric;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import com.speruri.java.cryptography.symmetric.SymmetricEncryptionUtils;

import junit.framework.Assert;

public class SymmetricEncryptionTest {

	@Test
	public void testGenerateSecretKey() throws NoSuchAlgorithmException {
		SecretKey secretKey = SymmetricEncryptionUtils.createSecretKey();
		Assert.assertNotNull(secretKey);
		System.out.println(DatatypeConverter.printHexBinary(secretKey.getEncoded()));
	}

	@Test
	public void testEncryptionAndDecryption() throws Exception {
		SecretKey secretKey = SymmetricEncryptionUtils.createSecretKey();
		byte[] initializationVector = SymmetricEncryptionUtils.createInitializationVector();
		String plainText = "Hi, this is Srikanth and Jyothi";
		byte[] encryptedString = SymmetricEncryptionUtils.performAESEncryption(plainText, secretKey,
				initializationVector);
		System.out.println("Encrypted String is " + DatatypeConverter.printHexBinary(encryptedString));
		String decryptedString = SymmetricEncryptionUtils.performAESDecryption(encryptedString, secretKey,
				initializationVector);
		System.out.println("Decrypted String is : " + decryptedString);
		Assert.assertEquals(plainText, decryptedString);
	}

}
