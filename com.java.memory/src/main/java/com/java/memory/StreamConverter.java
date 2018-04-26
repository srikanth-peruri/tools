package com.java.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class StreamConverter {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		byte[] fileContentBytes = IOUtils.toByteArray(new FileInputStream(new File("C:\\xml.txt")));
		String fileContentString = new String(fileContentBytes, "UTF-8");
		System.out.println("file content is : " + fileContentString);
		InputStream is = IOUtils.toInputStream(fileContentString, "UTF-8");
		FileOutputStream fos = new FileOutputStream(new File("E:\\newxml.txt"));
		IOUtils.copy(is, fos);
		System.out.println("Written the content..");
	}
}
