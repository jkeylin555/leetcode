package String;

public class KMP {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 1) {

		}
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

	public int[] getNext(char[] pattern) {
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

	public static void main(String[] args) {
		String str = "a";
		String str2 = "a";
		String str3 = "abbaca";
		int[] arr1 = {1,2,3,4,5,6,7};
		int[] arr2 = {1,1,2,1,1,2,1,1,1,1};
		KMP kmp = new KMP();
		int res = kmp.strStr(str, str2);
		System.out.println(res);

	}

}
