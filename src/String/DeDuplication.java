package String;

import java.util.ArrayList;
import java.util.List;

public class DeDuplication {
	//deDuplicate until hold 2 dumplicate eles
	public char[] deDuplication(String str) {
		int slow = 0, fast = 0, count = 0;
		char[] chars = str.toCharArray();
		while (fast < chars.length) {
			while (fast < chars.length && chars[fast] == chars[slow]) {
				fast++;
				count++;
			}
			if (count >= 3) {
				chars[slow + 2] = chars[fast++];
				slow += 2;
			}
			count = 0;
			while (fast < chars.length && chars[fast] != chars[slow]) {
				chars[++slow] = chars[fast++];
			}
		}
		return chars;
	}


	public String deDuplicationNew(String str) {
		int slow = 0, fast = 0, count = 0;
		char[] chars = str.toCharArray();
		List<Character> list = new ArrayList<>();
		while (fast < chars.length) {
			while (fast < chars.length && chars[fast] == chars[slow]) {
				fast++;
			}
			int diff = fast - slow;
			if (diff >= 2) {
				list.add(chars[slow]);
			}
			list.add(chars[slow]);
			slow = fast;
		}

		StringBuilder sb = new StringBuilder();
		for (Character c : list){
			sb.append(c);
		}

		return sb.toString();
	}
	//deDuplicate until no dumplicate eles
	public char[] deDuplication2(String str) {
		int slow = 0, fast = 1;
		char[] chars = str.toCharArray();
		while (fast < chars.length) {
			if (chars[fast] == chars[slow]) {
				fast++;
			} else {
				chars[++slow] = chars[fast++];
			}
		}
		return chars;
	}
	//deDuplicate until no dumplicate eles
	public char[] deDuplication3(String str) {
		int slow = 1, fast = 1;
		char[] chars = str.toCharArray();
		while (fast < chars.length) {
			if (chars[fast] == chars[slow - 1]) {
				fast++;
			} else {
				chars[slow++] = chars[fast++];
			}
		}
		return chars;
	}
	public static void main(String[] args) {
		String str = "aaabaaaa";
		DeDuplication deDuplication = new DeDuplication();
		System.out.println(deDuplication.deDuplicationNew(str));
	}
}
