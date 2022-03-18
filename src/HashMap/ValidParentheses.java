package HashMap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		Deque<Character> stack = new ArrayDeque<>();
		for (Character c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == map.get(c)) {
				stack.pop();
				} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid("({[)"));
		System.out.println(map.get('('));
	}
}
