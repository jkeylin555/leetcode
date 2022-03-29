package String;

import Sort.KthLargestElement;
import java.util.HashSet;
import java.util.Set;

public class CharRemoval {
	public int removeElement(int[] nums, int val) {
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] == val) {
				nums[slow] = nums[fast];
				slow++;
				fast++;
			} else {
				fast++;
			}
		}
		return slow;
	}


	public char[] removeChar(String str, Set<Character> set) {
		char[] chars = str.toCharArray();
		int slow = 0, fast = 0;
		while (fast < chars.length) {
			if (set.contains(chars[fast])) {
				fast++;
			} else {
				chars[slow] = chars[fast];
				slow++;
				fast++;
			}
		}
		return chars;
	}
	public static void main(String[] args) {
		String str = "student";
		Set<Character> set = new HashSet<>();
		set.add('u');
		set.add('e');
		CharRemoval charRemoval = new CharRemoval();
		System.out.println(charRemoval.removeChar(str, set));
	}
}
