package String;

import java.awt.print.PrinterGraphics;

public class ValidPalindromeII {
	class Pair {
		int left, right;
		public Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	public boolean validPalindrome(String s) {
		if (s == null) {
			return false;
		}

	    Pair pair = findDifference(s, 0, s.length() - 1);
		if (pair.left >= pair.right) {
			return true;
		}

		return isValidPalindrom(s, pair.left + 1, pair.right)
				|| isValidPalindrom(s, pair.left, pair.right - 1);
	}

	public boolean isValidPalindrom(String s, int left, int right) {
		Pair pair = findDifference(s, left, right);
		return pair.left >= pair.right;
	}

	private Pair findDifference(String s, int left, int right) {
		while (left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}
		return new Pair(left, right);
	}
}

