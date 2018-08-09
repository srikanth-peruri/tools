package com.speruri.java.cryptography.symmetric;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class SymmetricEncryptionUtils {

	private static String AES = "AES";
	private static String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

	public static SecretKey createSecretKey() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = new SecureRandom();
		KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
		keyGenerator.init(256, secureRandom);
		return keyGenerator.generateKey();
	}

	public static byte[] createInitializationVector() {
		byte[] initializationVector = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(initializationVector);
		return initializationVector;
	}

	public static byte[] performAESEncryption(String plainText, SecretKey secretKey, byte[] initializationVector)
			throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidAlgorithmParameterException {
		// Create the Crypto engine
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		// Since its a CBC (cipher block chaining mode), it needs the
		// initializing vector for the initial block,
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
		// Needs Secret key as well to encrypt the token
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		return cipher.doFinal(plainText.getBytes());
	}

	public static String performAESDecryption(byte[] encryptedText, SecretKey secretKey, byte[] initializationVector)
			throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] plaintext = cipher.doFinal(encryptedText);
		return new String(plaintext);
	}

}
