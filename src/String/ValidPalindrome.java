package String;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			while (left < right && !isValid(s.charAt(left))) {
				left++;
			}
			while (left < right && !isValid(s.charAt(right))) {
				right--;
			}
			if (!isEqual(s, left, right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private boolean isValid(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}

	private boolean isEqual(String s, int left, int right) {
		return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right));
	}

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";

		ValidPalindrome validPalindrome = new ValidPalindrome();
		boolean res = validPalindrome.isPalindrome(str);
		System.out.println(res);

	}


}
