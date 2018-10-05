package com.speruri.latest.algorithms.practice.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

public class ShortestPathChain {

	public static class QItem {

		int length;
		String word;

		public QItem(String argWord, int argLength) {
			this.word = argWord;
			this.length = argLength;
		}

	}

	public static boolean isAdjacent(String src, String dest) {
		if (src == null || dest == null || src.length() != dest.length()) {
			return false;
		}

		int count = 0;

		for (int i = 0; i < src.length(); i++) {
			if (src.charAt(i) != dest.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}

		return (count == 1);

	}

	public static int getShortestLength(String start, String target, Set<String> dict) {
		if (start == null || target == null || start.length() != target.length() || dict == null || dict.size() == 0) {
			return 0;
		}

		// Take a queue
		Queue<QItem> queue = new ArrayDeque();
		QItem item = new QItem(start, 1);
		queue.add(item);

		// Iterate while the queue os empty and then check the dictionary for
		// adjacent word
		QItem current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			Iterator<String> iterator = dict.iterator();
			while (iterator.hasNext()) {
				// Check in all the items of dictionary
				String currStr = iterator.next();
				if (isAdjacent(current.word, currStr)) {
					// If adjacent, then update the item with new word and
					// delete the item from dictionary to avaoid loops
					item.word = currStr;
					item.length = item.length + 1;
					queue.add(item);
					iterator.remove();
					if (currStr.equals(target)) {
						return item.length;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("poon");
		dictionary.add("plee");
		dictionary.add("same");
		dictionary.add("poie");
		dictionary.add("plie");
		dictionary.add("poin");
		dictionary.add("plea");
		String start = "toon";
		String target = "plea";
		System.out.println(getShortestLength(start, target, dictionary));
	}
}
