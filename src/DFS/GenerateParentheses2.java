package DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class GenerateParentheses2 {
	static List<List<Character>> results = new ArrayList<>();
	public void generate(int n, int[] brace, int[] bracket, int[] paratheses, int level, LinkedList<Character> list, Deque<Character> stack) {
		if (level  == 2 * n && stack.isEmpty()) {
			results.add(new ArrayList<>(list));
			return;
		}

		if (brace[1] < brace[0]) {
			list.add('{');
			stack.push('{');
			brace[1]++;
			generate(n, brace, bracket, paratheses, level + 1, list, stack);
			brace[1]--;
			list.removeLast();
			stack.pop();

		}
		if (brace[2] < brace[1] && stack.peek() == '{') {
			stack.pop();
			list.add('}');
			brace[2]++;
			generate(n, brace, bracket, paratheses, level + 1, list, stack);
			brace[2]--;
			list.removeLast();
			stack.push('{');
		}

		if (paratheses[1] < paratheses[0]) {
			list.add('(');
			stack.push('(');
			paratheses[1]++;
			generate(n, brace, bracket, paratheses, level + 1, list, stack);
			paratheses[1]--;
			list.removeLast();
			stack.pop();

		}
		if (paratheses[2] < paratheses[1] && stack.peek() == '(') {
			stack.pop();
			list.add(')');
			paratheses[2]++;
			generate(n, brace, bracket, paratheses, level + 1, list, stack);
			paratheses[2]--;
			list.removeLast();
			stack.push('(');
		}

		if (bracket[1] < bracket[0]) {
			list.add('[');
			stack.push('[');
			bracket[1]++;
			generate(n, brace, bracket, paratheses, level + 1, list, stack);
			bracket[1]--;
			list.removeLast();
			stack.pop();

		}
		if (bracket[2] < bracket[1] && stack.peek() == '[') {
			stack.pop();
			list.add(']');
			bracket[2]++;
			generate(n, brace, bracket, paratheses, level + 1, list, stack);
			bracket[2]--;
			list.removeLast();
			stack.push('[');
		}
	}

	public static void main(String[] args) {
		GenerateParentheses2 generateParentheses2 = new GenerateParentheses2();
        Deque<Character> stack = new ArrayDeque<>();
		LinkedList<Character> list = new LinkedList<>();
		int[] brace = {1, 0 , 0};
		int[] bracket = {1, 0 , 0};
		int[] paratheses = {1, 0 , 0};
		generateParentheses2.generate(3, brace, bracket, paratheses, 0, list, stack);

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
