package String;
import recursion.ReverseString;
public class ReverseStringII {
	ReverseString reverseString = new ReverseString();
	public String reverseStr(String s, int k) {
		char[] chars = s.toCharArray();
		reverse(chars, k, 0, chars.length - 1);
		return String.valueOf(chars);
	}
	private void reverse(char[] chars, int k, int left, int right) {
		if (right - left + 1 < k) {
			reverseString.reverse(chars, left, right);
		} else if (right - left + 1 > k && right - left + 1 < 2 * k) {
			reverseString.reverse(chars, left, left + k - 1);
		} else {
			reverseString.reverse(chars, left, left + k - 1);
			reverse(chars, k, left + 2 * k, right);
		}
	}

	public static void main(String[] args) {
		String str = "a";
		String str2 = "a";
		String str3 = "abcdefg";
		ReverseStringII reverseStringII = new ReverseStringII();
		String res = reverseStringII.reverseStr(str3, 2);
		System.out.println(res);

	}
}
