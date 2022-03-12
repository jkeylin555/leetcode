package laioffer;

import java.util.Arrays;

public class QuickSort {
	public void quickSort(int[] array, int left, int right) {
		if (right <= left) {
			return;
		}
		int pivotRand = (int)(Math.random() * (right - left) + left);
		swap(array, left, pivotRand);
		int start = left + 1;
		int end = right;
		while (start < end) {
			while (array[start] <= array[left] && start < end) {
				start++;
			}
			while (array[end] > array[left] && start < end) {
				end--;
			}
			swap(array, start, end);
		}
		swap(array, left, start - 1);
		quickSort(array, left, start - 1);
		quickSort(array, start, right);

	}
	private void swap (int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	public static void main(String[] args) {
//		System.out.println((int)(Math.random() * 5));
		int[] array = {3, 1, 2, 4, 7, 6, 2, 4, 3, 5};
		int[] array2 = {-3, 1};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(array2, 0, array2.length - 1);
		System.out.println(Arrays.toString(array2));

	}
}



