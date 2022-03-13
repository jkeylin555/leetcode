package exercise.FastSlowPointers;

import java.util.Arrays;

public class MoveZeros {
	private void moveZeros (int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			while (left < right && arr[right] == 0) {
				right--;
			}
			while (left < right && arr[left] != 0) {
				left++;
			}
			swap(arr, left, right);
			left++;
			right--;
		}
	}
	private void swap (int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	private void moveZeros2 (int[] arr) {
		int slow = 0, fast = 0;
		while (fast <= arr.length - 1) {
			if (arr[fast] == 0) {
				fast++;
			} else {
				arr[slow++] = arr[fast++];
			}

		}
		while (slow <= arr.length - 1) {
			arr[slow++] = 0;
		}
	}

	public static void main(String[] args) {
		int[] arr = {0,1,0,3,12};
		MoveZeros moveZeros = new MoveZeros();
		moveZeros.moveZeros2(arr);
		System.out.println(Arrays.toString(arr));
	}

}


