package String;

import java.util.HashSet;
import java.util.Set;

public class RemoveSpaces {
	public char[] remove(String str) {
		int slow = 0, fast = 0;
		char[] chars = str.toCharArray();
		int count = 0;
		while (fast < chars.length) {
			while (fast < chars.length && chars[fast] == ' ') {
				fast++;
			}
			if (count > 0) {
				chars[slow++] = ' ';
			}
			while (fast < chars.length && chars[fast] != ' ') {
				chars[slow++] = chars[fast++];
			}
			count++;
		}

		return chars;
	}
	public static void main(String[] args) {
		String str = "       st      ud      en t     ";
		RemoveSpaces removeSpaces = new RemoveSpaces();
		System.out.println(removeSpaces.remove(str));
	}
}
