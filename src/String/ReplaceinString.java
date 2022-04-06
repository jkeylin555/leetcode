package String;

import java.lang.module.FindException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReplaceinString {
	class Pair {
		int index;
		int sourceLen;
		String target;
		public Pair(int index, int sourceLen, String target) {
			this.index  = index;
			this.sourceLen = sourceLen;
			this.target = target;
		}
	}
	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if (p1 == p2) return 0;
				return p1.index < p2.index ? -1 : 1;
			}
		});

		int i = 0;
		while (i < indices.length) {
			if (indices[i] + sources[i].length() <= s.length() && s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])) {
				pq.offer(new Pair(indices[i], sources[i].length(), targets[i]));
			}
			i++;
		}
		i = 0;
		int j = 0;
		StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
			if (!pq.isEmpty() && i == pq.peek().index && j <= pq.peek().index) {
				Pair top = pq.poll();
				sb.append(top.target);
				j += top.sourceLen;
				i += top.sourceLen;

			} else {
				sb.append(s.charAt(i));
				i++;
			}
		}
		return sb.toString();
	}



	public String findReplaceString2(String s, int[] indices, String[] sources, String[] targets) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxIndex = 0;
		for (int i = 0; i < indices.length; i++) {
			if (indices[i] + sources[i].length() <= s.length() && s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])) {
				map.put(indices[i], i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i >= maxIndex) {
				if (map.containsKey(i)) {
					sb.append(targets[map.get(i)]);
					i = i + sources[map.get(i)].length() - 1;
				} else {
					sb.append(s.charAt(i));
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "abcd";
		int[] indices = {0, 2};
		String[] sources = {"ab","cd"};
		String[] target = {"ffff","eeee"};
		ReplaceinString replaceinString = new ReplaceinString();
		String res = replaceinString.findReplaceString2(s, indices, sources, target);

		System.out.println(res);

	}
}
