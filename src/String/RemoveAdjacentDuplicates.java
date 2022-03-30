package String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveAdjacentDuplicates {
	public String removeDuplicates(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		int i = 0;
		while (i < chars.length) {
			if (!stack.isEmpty() && stack.peek() == chars[i]) {
				while (i < chars.length && stack.peek() == chars[i]) {
					i++;
				}
				stack.pop();
			} else {
				stack.push(chars[i]);
				i++;
			}

		}
		String str = "";
		while (!stack.isEmpty()) {
			str += stack.pollLast();
		}
		return str;

	}

	public String removeDuplicates2(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		String str = "";
		while (!stack.isEmpty()) {
			str += stack.pollLast();
		}
		return str;

	}
	public static void main(String[] args) {
		String str = "aaaaaaa";
		String str2 = "azxxzy";
		RemoveAdjacentDuplicates removeAdjacentDuplicates = new RemoveAdjacentDuplicates();
		System.out.println(removeAdjacentDuplicates.removeDuplicates2(str));
	}

}
