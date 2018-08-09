package com.speruri.java.cryptography.keystore;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyStore;

import javax.crypto.SecretKey;

public class KeystoreUtils {

	private static final String SECRET_KEY_KEYSTORE_TYPE = "JCEKS";

	public static KeyStore createPrivateKeyJavaKeyStore(String keystorePassword, String keyAlias, SecretKey secretKey,
			String secretKeyPassword) throws Exception {
		// Create a Keystore of type JCKES
		KeyStore keyStore = KeyStore.getInstance(SECRET_KEY_KEYSTORE_TYPE);
		// Load this in memory with a password
		keyStore.load(null, keystorePassword.toCharArray());

		// Create a secret entry in the key store
		KeyStore.SecretKeyEntry privateKeyEntry = new KeyStore.SecretKeyEntry(secretKey);

		// Create a entry password
		KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(secretKeyPassword.toCharArray());

		// Then finally set the key alias, pwd, entry into the key store
		keyStore.setEntry(keyAlias, privateKeyEntry, entryPassword);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("keystore.jks"));
			keyStore.store(fos, keystorePassword.toCharArray());
			System.out.println("Keystore created");
		} catch (Exception e) {
			throw new RuntimeException("Exception while saving the keystore.." + e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception ignore) {
					// TODO: handle exception
				}
			}
		}
		return keyStore;
	}

}
