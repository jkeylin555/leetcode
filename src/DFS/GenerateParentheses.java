package DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	static List<List<Character>> results = new ArrayList<>();
	public void generate(int n, int level, LinkedList<Character> s, int l, int r) {
		if (l + r == 2 * n) {
			results.add(new ArrayList<>(s));
			return;
		}
		if (l < n) {
			s.add('(');
			generate(n, level + 1, s, l + 1, r);
			s.removeLast();
		}
		if (r < l) {
			s.add(')');
			generate(n, level + 1, s, l, r + 1);
			s.removeLast();
		}
	}
	public static void main(String[] args) {
		GenerateParentheses generateParentheses = new GenerateParentheses();

		LinkedList<Character> list = new LinkedList<>();
		generateParentheses.generate(3, 0, list, 0, 0);

		List<String> solution = new ArrayList<>();
		for (int i = 0; i < results.size(); i++) {
			StringBuffer sb = new StringBuffer();
			for (Character c : results.get(i)) {
				sb.append(c);
			}
			solution.add(sb.toString());
		}
		System.out.println(solution);
	}
}
