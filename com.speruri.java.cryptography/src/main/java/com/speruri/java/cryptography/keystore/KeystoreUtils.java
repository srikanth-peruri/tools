package com.speruri.java.cryptography.keystore;

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

		return keyStore;
	}

}
