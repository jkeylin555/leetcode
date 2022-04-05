package String;

import java.util.ArrayDeque;
import java.util.Deque;
import recursion.ReverseString;

public class ReverseYahool {
	public String reverse(String str) {
		ReverseString reverseString = new ReverseString();
		StringBuilder result = new StringBuilder();
		char[] chars = str.toCharArray();
		int i = 0, j = 0, k = 0;
		while (chars[k] == ' ' && k < chars.length) {
			k++;
		}
		i = k;
		while (j < chars.length) {
			if (j == chars.length - 1)  {
				reverseString.reverse(chars, i, j);
				break;
			} else if (chars[j] == ' ' ) {
				reverseString.reverse(chars, i, j - 1);
				j++;
				i = j;
			} else {
				j++;
			}
		}
		reverseString.reverse(chars, 0, chars.length - 1);
		return String.valueOf(chars);
	}

	public String reverseWords(String s) {
		StringBuilder word = new StringBuilder();
		Deque<String> stack = new ArrayDeque<>();
		int i = 0, j = s.length() - 1;
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		while (j >= 0 && s.charAt(j) == ' ') {
			j--;
		}
		while (i <= j) {
		if (word.length() != 0 && s.charAt(i) == ' ' || i == j) {
				stack.push(word.toString());
				word.setLength(0);
				i++;
			} else if (s.charAt(i) != ' '){
				word.append(s.charAt(i));
				i++;
			} else {
			i++;
		    }
		}
		return String.join(" ", stack);
	}


	public String reverseWords2(String s) {
		StringBuilder sb = trimSpaces(s);
		reverse(sb, 0, sb.length() - 1);
		int i = 0, j = 0;
		while (j < sb.length()) {
			if (sb.charAt(j) == ' ') {
				reverse(sb, i, j - 1);
				i = ++j;
			} else {
				++j;
			}
		}
		reverse(sb, i, j - 1);

		return sb.toString();

	}
	private void reverse (StringBuilder sb, int left, int right) {
		if (left >= right) return;;
		swap(sb, left, right);
		reverse(sb, ++left, --right);
	}

	private void swap (StringBuilder sb, int left, int right) {
		char temp = sb.charAt(left);
		sb.setCharAt(left, sb.charAt(right));
		sb.setCharAt(right, temp);
	}


	public StringBuilder trimSpaces(String s) {
		StringBuilder words = new StringBuilder();
		int i = 0, j = s.length() - 1;
		while (i < s.length() - 1 && s.charAt(i) == ' ') {
			i++;
		}
		while (j > i && s.charAt(j) == ' ') {
			j--;
		}
		while (i <= j) {
			char c = s.charAt(i);
			if (c != ' ') {
				words.append(c);
			} else if (words.charAt(words.length() - 1) != ' ' && c == ' ') {
				words.append(c);
			}
			++i;
		}
		return words;
	}


	public static void main(String[] args) {
		String str = "a";
		String str2 = "a";
		String str3 = "the sky is blue";
		ReverseYahool reverseYahool = new ReverseYahool();
		String res = reverseYahool.reverseWords2(str3);
		System.out.println(res);

	}
}
