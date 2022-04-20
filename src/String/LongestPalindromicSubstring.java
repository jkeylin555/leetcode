package String;

public class LongestPalindromicSubstring {
	public String longestPalindrom(String s) {
		String longestPalindrom = "";
		for (int i = 0; i < s.length(); i++) {
			if (longestPalindrom.length() < getPalindromFrom(s, i, i).length()) {
				longestPalindrom = getPalindromFrom(s, i, i);
			}
			if (longestPalindrom.length() < getPalindromFrom(s, i, i + 1).length()) {
				longestPalindrom = getPalindromFrom(s, i, i);
			}

		}
		return longestPalindrom;

	}


	public String longestPalindrom2(String s) {
		if (s == null || s.equals("")) {
			return "";
		}

		int longestLength = 0, start = -1;
		boolean[][] isPalindrom = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			isPalindrom[i][i] = true;
			longestLength = 1;
			start = i;
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				isPalindrom[i][i + 1] = true;
				longestLength = 2;
				start = i;
			}
		}

	    for (int i = s.length() - 1; i >= 0; i--) {
	    	for (int j = i + 2; j < s.length(); j++) {
	    		if (i < s.length() - 1 && j > 0) {
					isPalindrom[i][j] = s.charAt(i) == s.charAt(j) && isPalindrom[i + 1][j - 1];
				}
				if (isPalindrom[i][j] && j - i + 1 > longestLength) {
					longestLength = j - i + 1;
					start = i;
				}
			}
		}
	    if (start > - 1) {
			return s.substring(start, start + longestLength);
		} else {
			return "";
		}



	}


	private String getPalindromFrom(String s, int left, int right) {
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			}
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	public static void main(String[] args) {
		String str = "a";
		String str2 = "cbbd";
		String str3 = "babad";
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		String res = longestPalindromicSubstring.longestPalindrom2(str);
		System.out.println(res);

	}
}
