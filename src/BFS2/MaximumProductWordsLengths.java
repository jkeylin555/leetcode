package BFS2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumProductWordsLengths {
	public int maxProduct(String[] words) {
		if (words.length < 2) {
			return 0;
		}
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return 0;
				}
				return o1.length() > o2.length() ? -1 : 1;
			}
		});
		PriorityQueue<Pair> maxHeap = new PriorityQueue(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if (p1.product == p2.product) {
					return 0;
				}
				return p1.product > p2.product ? -1 : 1;
			}
		});
		maxHeap.add(new Pair(0, 1, words));
		while (!maxHeap.isEmpty()) {
			Pair top = maxHeap.poll();
			if (valid(top, words)) {
				return top.product;
			}
			int x = top.x;
			int y = top.y;
			if (x + 1 < words.length) {
				maxHeap.offer(new Pair(x + 1, y, words));
			}
			if (y + 1 < words.length) {
				maxHeap.offer(new Pair(x, y + 1, words));
			}
		}
		return 0;
	}
	public boolean valid(Pair pair, String[] words) {
		String s1 = words[pair.x];
		String s2 = words[pair.y];
		Set<Character> set = new HashSet<>();

		for (char c : s1.toCharArray()) {
			set.add(c);
		}
		for (char c : s2.toCharArray()) {
			if (set.contains(c)) {
				return false;
			}
		}
		return true;
	}
	public class Pair{
		int x, y;
		int product;
		public Pair(int x, int y, String[] words) {
			this.x = x;
			this.y = y;
			this.product = words[x].length() * words[y].length();
		}
	}
	public static void main(String[] args) {
		String[] str = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
		MaximumProductWordsLengths maximumProductWordsLengths = new MaximumProductWordsLengths();
		int result = maximumProductWordsLengths.maxProduct(str);

//		List<String> result = maximumProductWordsLengths.maxProduct(str);
		System.out.println(result);
	}
}
