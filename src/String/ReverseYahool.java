package String;

import recursion.ReverseString;

public class ReverseYahool {
	public String reverse(String str) {
		ReverseString reverseString = new ReverseString();
		char[] chars = str.toCharArray();
		int i = 0, j = 0;
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
		String res = "";
		for (int k = 0; k < chars.length; k++) {
			res += chars[k];
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "a";
		String str2 = "a";
		String str3 = "I love yahool";
		ReverseYahool reverseYahool = new ReverseYahool();
		String res = reverseYahool.reverse(str3);
		System.out.println(res);

	}
}
