package com.java.memory.classloader.memoryleak;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeaker {
	public static void main(String[] args) {
		List<Brick> bricks = new ArrayList<>();

		while (true) {
			bricks.add(new Brick());
		}
	}
}
