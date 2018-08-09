package com.speruri.java.cryptography.digitalsignatures;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.speruri.java.cryptography.asymmetric.AsymmetricEncryptionUtils;

public class DigitalSignaturesUtilsTest {

	@Test
	public void testVerify() throws Exception {
		URL url = this.getClass().getClassLoader().getResource("constitution.txt");
		Path path = Paths.get(url.toURI());
		byte[] input = Files.readAllBytes(path);

		URL url1 = this.getClass().getClassLoader().getResource("constitution1.txt");
		Path path1 = Paths.get(url1.toURI());
		byte[] input1 = Files.readAllBytes(path1);

		KeyPair rsaKeypair = AsymmetricEncryptionUtils.generateRSAKeypair();
		PrivateKey privateKey = rsaKeypair.getPrivate();
		PublicKey publicKey = rsaKeypair.getPublic();

		byte[] digitalSignature = DigitalSignaturesUtils.createDigitalSignature(input, privateKey);
		Assert.assertNotNull(digitalSignature);
		System.out.println(DatatypeConverter.printHexBinary(digitalSignature));

		boolean verifyDigitalSignature = DigitalSignaturesUtils.verifyDigitalSignature(input, digitalSignature,
				publicKey);
		System.out.println("Is Correct ? : " + verifyDigitalSignature);
		Assert.assertEquals(true, verifyDigitalSignature);

	}

}
