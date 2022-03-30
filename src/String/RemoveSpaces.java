package String;

import java.util.HashSet;
import java.util.Set;

public class RemoveSpaces {
	public char[] remove(String str) {
		int slow = 0, fast = 0;
		char[] chars = str.toCharArray();
		boolean flag = false;
		while (fast < chars.length) {
			while (fast < chars.length && chars[fast] == '_') {
				fast++;
			}
			if (fast == chars.length) {
				break;
			}
			if (flag) {
				chars[slow++] = ' ';
			}
			while (fast < chars.length && chars[fast] != '_') {
				chars[slow++] = chars[fast++];
			}
			flag = true;
		}

		return chars;
	}
	public static void main(String[] args) {
		String str = "_____st___ud____en_t______";
		RemoveSpaces removeSpaces = new RemoveSpaces();
		System.out.println(removeSpaces.remove(str));
	}
}
