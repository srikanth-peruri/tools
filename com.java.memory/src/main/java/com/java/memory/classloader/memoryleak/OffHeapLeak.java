package com.java.memory.classloader.memoryleak;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class OffHeapLeak {
	private static final int SIZE = 64 * 1024 * 1024;

	public static void main(String[] args) throws IOException {
		final List<ByteBuffer> buffers = new ArrayList();

		while (true) {
			buffers.add(ByteBuffer.allocateDirect(SIZE));
			buffers.add((MappedByteBuffer) MappedByteBuffer.allocateDirect(SIZE));

			System.out.println("Enter to allocate");
			System.in.read();
		}
	}
}
