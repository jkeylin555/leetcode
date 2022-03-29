package DP;

public class LongestSubstring {
	public int longestSubstring(String s) {
		char[] string = s.toCharArray();
		int count = 0;
		int res = 0;
		for (int i = 1; i < string.length; i++) {
			if (string[i] == string[i - 1]) {
				continue;
			} else {
				count++;
			}
		}
		return 0;
	}
}
