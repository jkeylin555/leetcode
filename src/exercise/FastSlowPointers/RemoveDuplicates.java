package exercise.FastSlowPointers;

import java.util.Arrays;

public class RemoveDuplicates {
	private int[] removeDuplicates(int[] array) {
		if (array.length <= 0) {
			return new int[0];
		}
		int slow = 0, fast = 0;
		while (fast < array.length - 1) {
			if (array[fast + 1] == array[fast]) {
				fast++;
			} else {
				array[++slow]  = array[++fast];
			}
		}
		return array;

	}

	private int[] removeDuplicates2(int[] array) {
		if (array.length <= 0) {
			return new int[0];
		}
		int slow = 0, fast = 0, count = 1;
		while (fast < array.length - 1) {
			if (array[fast + 1] == array[fast]) {
				fast++;
				count++;
				if (count <= 2) {
					array[++slow] = array[fast];
				}
			} else {
				array[++slow]  = array[++fast];
				count = 1;
			}
		}

		return array;

	}
	public static void main(String[] args) {
		int[] array = {0,0,1,1,1,2,2,3,3,4};
		int[] array2 = {1,1,1,2,2,3};
		int[] array3 = {1,1,1,1,2,2,3,3};
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] result = removeDuplicates.removeDuplicates2(array2);
		System.out.println(Arrays.toString(result));
	}


}
