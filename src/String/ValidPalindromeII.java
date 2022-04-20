package String;

import java.awt.print.PrinterGraphics;

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		if (s == null) {
			return false;
		}
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			}
			left++;
			right--;
		}

		if (left >= right) {
			return true;
		}

		return isValidPalindrom(s, left + 1, right) || isValidPalindrom(s, left, right - 1);
	}

	public boolean isValidPalindrom(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

