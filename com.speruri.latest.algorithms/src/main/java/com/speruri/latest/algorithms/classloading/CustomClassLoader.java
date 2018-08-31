package com.speruri.latest.algorithms.classloading;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader {
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		URL urls = new URL("file:///E:/personal/my_practice/tools/com.speruri.classloading/lib");
		URLClassLoader ucl = new URLClassLoader(new URL[] { urls });
		Class<?> clazz = ucl.loadClass("com.speruri.classloading.Main");
		Object newInstance = clazz.newInstance();
		System.out.println(newInstance.toString());
	}
}
