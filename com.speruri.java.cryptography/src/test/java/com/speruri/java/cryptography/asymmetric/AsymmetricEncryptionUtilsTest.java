package com.speruri.java.cryptography.asymmetric;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.bind.DatatypeConverter;

import org.junit.Assert;
import org.junit.Test;

public class AsymmetricEncryptionUtilsTest {

	@Test
	public void testGenerateRSAKeypair() throws Exception {
		KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeypair();
		Assert.assertNotEquals(keyPair, null);
		PrivateKey privateKey = keyPair.getPrivate();
		System.out.println("Private key is : " + DatatypeConverter.printHexBinary(privateKey.getEncoded()));
		PublicKey publicKey = keyPair.getPublic();
		System.out.println("Public key is : " + DatatypeConverter.printHexBinary(publicKey.getEncoded()));
	}

	@Test
	public void testEncryptionDecryption() throws Exception {
		String plainText = "This is Srikanth and Jyothi";
		KeyPair rsaKeypair = AsymmetricEncryptionUtils.generateRSAKeypair();
		PrivateKey privateKey = rsaKeypair.getPrivate();
		PublicKey publicKey = rsaKeypair.getPublic();

		byte[] encryptedBytes = AsymmetricEncryptionUtils.performRSAEncryption(plainText, privateKey);
		System.out.println("Encrypted Token : " + DatatypeConverter.printHexBinary(encryptedBytes));

		String decryptedText = AsymmetricEncryptionUtils.performRSADecryption(encryptedBytes, publicKey);
		System.out.println("Decrypted Token : " + decryptedText);
		Assert.assertEquals(plainText, decryptedText);

	}

}
