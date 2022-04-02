package recursion;

public class ReverseString {
	public void reverse(char[] chars, int left, int right) {
		if (right <= left) {
			return;
		}
		swap(chars, left, right);
		reverse(chars, left + 1, right - 1);
	}
	private void swap(char[] chars, int left, int right) {
		char temp = chars[left];
		chars[left] = chars[right];
		chars[right] = temp;
	}

	public static void main(String[] args) {
		String str = "a";
		String str2 = "a";
		String str3 = "abbaca";

	}

}
