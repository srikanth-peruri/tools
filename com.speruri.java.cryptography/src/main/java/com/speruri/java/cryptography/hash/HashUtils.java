package com.speruri.java.cryptography.hash;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtils {

	// Rainbow tables are pre comuted tables with hashes
	private static final String SHA2_ALGORITHM = "SHA-256";
	private static final String MD5_ALGORITHM = "MD5";

	public static byte[] generateRandomSalt() {
		byte[] salt = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);
		return salt;
	}

	public static byte[] createSHA2Hash(String input, byte[] salt) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(salt);
		bos.write(input.getBytes());
		byte[] valueToHash = bos.toByteArray();
		MessageDigest messageDigest = MessageDigest.getInstance(SHA2_ALGORITHM);
		return messageDigest.digest(valueToHash);
	}

	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static boolean verifyPassword(String userPassword, String dbPassword) {
		return BCrypt.checkpw(userPassword, dbPassword);
	}

}
