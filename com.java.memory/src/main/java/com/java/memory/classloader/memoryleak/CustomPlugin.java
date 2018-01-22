package com.java.memory.classloader.memoryleak;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomPlugin implements Plugin {

	private long[] LOT_OF_MEMORY = new long[8 * 1024 * 1024];

	private ExampleLevel level = new ExampleLevel();

	@Override
	public void initialize() {
		Logger.getLogger(CustomPlugin.class.getName()).log(level, "Hello World");
	}

	class ExampleLevel extends Level {
		protected ExampleLevel() {
			super("Example Plugin", 1000);
		}
	}

}
