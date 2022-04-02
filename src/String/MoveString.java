package String;
import recursion.ReverseString;

public class MoveString {
	public String reverse(String s, int k) {
		char[] chars = s.toCharArray();
		ReverseString reverseString = new ReverseString();
		reverseString.reverse(chars, 0, chars.length - k - 1);
		reverseString.reverse(chars, chars.length - k, chars.length - 1);
		reverseString.reverse(chars, 0, chars.length - 1);
		String res = "";
		for (int i = 0; i < chars.length; i++) {
			res += chars[i];
		}
		return res;
	}
	public static void main(String[] args) {
		String str = "a";
		String str2 = "a";
		String str3 = "abcdef";
		MoveString reverseStringII = new MoveString();
		String res = reverseStringII.reverse(str3, 2);
		System.out.println(res);

	}

}
