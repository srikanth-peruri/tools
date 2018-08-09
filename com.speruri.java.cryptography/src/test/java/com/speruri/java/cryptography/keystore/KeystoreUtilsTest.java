package com.speruri.java.cryptography.keystore;

import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;

import javax.crypto.SecretKey;

import org.junit.Test;

import com.speruri.java.cryptography.symmetric.SymmetricEncryptionUtils;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class KeystoreUtilsTest {

	@Test
	public void testCreateKeyStore() throws Exception {
		SecretKey secretKey = SymmetricEncryptionUtils.createSecretKey();

		String keystorePassword = "keyStorePasswod";
		String keyAlias = "foo";
		String secretKeyPassword = "keyPassword";
		KeyStore privateKeyJavaKeyStore = KeystoreUtils.createPrivateKeyJavaKeyStore(keystorePassword, keyAlias,
				secretKey, secretKeyPassword);
		Assert.assertNotNull(privateKeyJavaKeyStore);

		privateKeyJavaKeyStore.load(null, keystorePassword.toCharArray());

		KeyStore.PasswordProtection entryPassword = new KeyStore.PasswordProtection(secretKeyPassword.toCharArray());
		KeyStore.SecretKeyEntry secretEntry = (SecretKeyEntry) privateKeyJavaKeyStore.getEntry(keyAlias, entryPassword);
		SecretKey secretKeyFromKS = secretEntry.getSecretKey();
		Assert.assertNotNull(secretKeyFromKS);

		org.junit.Assert.assertEquals(secretKey, secretKeyFromKS);

	}

}
