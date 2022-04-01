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

	public String removeDuplicates3(String s) {
		char[] chars = s.toCharArray();
		int slow = 0, fast = 1;
		while (fast < chars.length) {
			if (slow >= 0 && chars[fast] == chars[slow]) {
				while (fast < chars.length && chars[fast] == chars[slow]) {
					fast++;
				}
				slow--;
			} else {
				chars[++slow] = chars[fast++];
			}

		}
		String str = "";
		for (int i = 0; i <= slow; i++) {
			str += chars[i];
		}
		return str;
	}

	// use virtual stack 
	public String removeDuplicates4(String s) {
		char[] chars = s.toCharArray();
		int slow = -1, fast = 0;
		while (fast < chars.length) {
			if (slow >= 0 && chars[fast] == chars[slow]) {
				fast++;
				slow--;
			} else {
				chars[++slow] = chars[fast++];
			}

		}
		String str = "";
		for (int i = 0; i <= slow; i++) {
			str += chars[i];
		}
		return str;
	}
	public static void main(String[] args) {
		String str = "aaaaaaaa";
		String str2 = "azxxzy";
		String str3 = "abbaca";
		RemoveAdjacentDuplicates removeAdjacentDuplicates = new RemoveAdjacentDuplicates();
		System.out.println(removeAdjacentDuplicates.removeDuplicates4(str));
	}

}
