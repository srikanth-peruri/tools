package com.java.memory.classloader.memoryleak;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class LoaderTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InterruptedException {
		String pluginName = CustomPlugin.class.getPackage() + "." + CustomPlugin.class.getSimpleName();
		Map<String, Object> map = new HashMap<>();
		int count = 0;
		while (true) {
			Thread.currentThread().sleep(5000);
			URL[] urls = { new File("target/classes").toURI().toURL() };
			URLClassLoader classLoader = new URLClassLoader(urls, null);
			Class<?> aClass = classLoader.loadClass(pluginName);
			Object obj = aClass.newInstance();
			map.put("" + count++, obj);
			aClass.getMethod("initialize").invoke(obj);
		}
	}
}
