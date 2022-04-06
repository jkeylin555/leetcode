package String;
import recursion.ReverseString;

public class StringSuffling {
	ReverseString reverseString = new ReverseString();
	public String suffling(String s) {
		char[] chars = s.toCharArray();
		char[] res = sufflingHelper(chars, 0, chars.length - 1);
		return String.valueOf(res);


	}
	public char[] sufflingHelper(char[] chars, int left, int right) {
		if (right - left > 1) {
			int size = right - left + 1;
			int lr = left + size / 4;
			int mid = left + size / 2;
			int rl = left + 3 * size / 4;

			reverseString(chars, lr, mid, rl - 1);
			sufflingHelper(chars, left, left + (lr - left) * 2 - 1);
			sufflingHelper(chars, left + (lr - left) * 2, right);
		}
		return chars;
	}

	public void reverseString(char[] chars, int left, int mid, int right) {
		reverseString.reverse(chars, left, right);
		reverseString.reverse(chars, left, left + right - mid);
		reverseString.reverse(chars, left + right - mid + 1, right);
	}

	public static void main(String[] args) {
		String str3 = "ABCD1234";
		StringSuffling stringSuffling = new StringSuffling();
		System.out.println(stringSuffling.suffling(str3));


	}

}
