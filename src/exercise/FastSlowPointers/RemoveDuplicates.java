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

	private int[] removeDuplicates2_2(int[] array) {
		if (array.length <= 0) {
			return new int[0];
		}
		int slow = 2, fast = 2;
		while (fast < array.length) {
			if (array[fast] == array[slow - 2]) {
				fast++;
			} else {
				array[slow++]  = array[fast++];
			}
		}

		return array;
	}

    private int[] removeDuplicates3(int[] array) {
		int slow = 0, fast = 0, counter = 1;
		while (fast < array.length - 1) {
			if (array[fast] == array[fast + 1]) {
				fast++;
				counter++;
			} else {
				if (counter > 1) {
					fast++;
					counter = 1;
				} else {
					array[slow++] = array[fast++];
				}
				if (fast ==  array.length - 1) {
					array[slow++] = array[fast++];
				}
			}
		}
		return array;
	}

	private int[] removeDuplicates4(int[] array) {
		int slow = 0, fast = 0, begin;
		while (fast < array.length) {
			begin = fast;
			while (fast < array.length && array[fast] == array[begin]) {
				fast++;
			}
			if (fast - begin == 1) {
				array[slow++] = array[begin];
			}
		}
		return array;
	}



	public static void main(String[] args) {
		int[] array = {0,0,1,1,1,2,2,3,3,4};
		int[] array2 = {1,1,1,2,2,3};
		int[] array3 = {1,1,1,1,2,2,3,3};
		int[] array4 = {1,1,2,3,3};
		int[] array5 = {1,1,2,3,4,4,4,5};
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] result = removeDuplicates.removeDuplicates4(array5);
		System.out.println(Arrays.toString(result));
	}


}


