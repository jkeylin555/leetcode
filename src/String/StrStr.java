package String;

public class StrStr {
	public int strStr(String haystack, String needle) {
		int[] next = getNext(needle.toCharArray());
		int i = 0, j = 0;
		while (i < haystack.length()  && j < needle.length()) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j >= needle.length()) {
			return i - j;
		} else {
			return -1;
		}
	}

	private int[] getNext(char[] pattern) {
		if (pattern.length < 2) {
			return new int[]{-1};
		}
		int[] next = new int[pattern.length];
		next[0] = -1;
		next[1] = 0;
		int k = 0, j = 2;
		while (j < pattern.length) {
			if (k == -1 || pattern[j - 1] == pattern[k]) {
				next[j] = k + 1;
				k++;
				j++;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public int BASE = 1000000;
	public int strStr2(String haystack, String needle) {
		// 31 ^ targetLength
		int power = 1, targetLength = needle.length();
		for (int i = 0; i < targetLength; i++) {
			power = power * 31;
		}

		int targetNumber = 0;
		for (int i = 0; i < targetLength; i++) {
			targetNumber = targetNumber * 31 + needle.charAt(i);
		}

		int sourceNumber = 0;
		for (int i = 0; i < haystack.length(); i++) {
			sourceNumber = sourceNumber * 31 + haystack.charAt(i);
			if (i >= targetLength) {
				sourceNumber -= (haystack.charAt(i - targetLength)) * power;
			}

			if (sourceNumber == targetNumber) {
				return i - targetLength + 1;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		String str = "aaa";
		String str2 = "aa";
		String str3 = "abbaca";
		int[] arr1 = {1,2,3,4,5,6,7};
		int[] arr2 = {1,1,2,1,1,2,1,1,1,1};
		StrStr strStr = new StrStr();
		int res = strStr.strStr2(str, str2);
		System.out.println(res);

	}

}
