package laioffer;

import java.util.Arrays;

public class QuickSort {
	public void quickSort(int[] array, int left, int right) {
		if (right <= left) {
			return;
		}
		int pivotRand = (int)(Math.random() * (right - left) + left);
		swap(array, left, pivotRand);
		int start = left ;
		int end = right;
		while (start < end) {
			while (array[end] > array[left] && start < end) {
				end--;
			}
			while (array[start] <= array[left] && start < end) {
				start++;
			}
			swap(array, start, end);
		}
		swap(array, left, end);
		quickSort(array, left, end - 1);
		quickSort(array, end + 1, right);

	}
	private void swap (int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}


	public void quickSort2(int[] array, int left, int right) {
		if (right <= left) {
			return;
		}
		int pivotRand = (int)(Math.random() * (right - left) + left);
		swap(array, left, pivotRand);
		int start = left ;
		int end = right;
		while (start <= end) {
			while (end >= 0 && array[end] > array[left] && start <= end) {
				end--;
			}
			while (start < array.length && array[start] <= array[left] && start <= end ) {
				start++;
			}
			if (start < end) {
				swap(array, start, end);
				start++;
				end--;
			}

		}
		swap(array, left, end);
		quickSort2(array, left, end - 1);
		quickSort2(array, end + 1, right);

	}

	public static void main(String[] args) {
		int[] array = {3, 1, 2, 4, 7, 6, 2, 4, 3, 5};
		int[] array2 = {1, -3};
		int[] array3 = {5, 2, 3, 1};
		int[] array4 = {1, -3};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort2(array3, 0, array3.length - 1);
		System.out.println(Arrays.toString(array3));
	}
}


