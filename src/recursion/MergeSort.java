package recursion;

public class MergeSort {
	public void mergeSort(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return;
		}

		int[] temp = new int[nums.length];
		mergeIntegers(nums, 0, nums.length - 1, temp);
	}

	private void mergeIntegers(int[] nums, int start, int end, int[] temp) {
		if (start >= end) {
			return;
		}

		mergeIntegers(nums, start, (start + end) / 2, temp);
		mergeIntegers(nums, (start + end) / 2 + 1, end, temp);
		merge(nums, start, end, temp);
	}

	private void merge(int[] nums, int start, int end, int[] temp) {
		int leftIndex = start;
		int middle = (start + end) / 2;
		int rightIndex = (start + end) / 2 + 1;
		int index = start;

		while (leftIndex <= middle && rightIndex <= end) {
			if (nums[leftIndex] < nums[rightIndex]) {
				temp[index++] = nums[leftIndex++];
			} else {
				temp[index++] = nums[rightIndex++];
			}
		}

		while (leftIndex <= middle) {
			temp[index++] = nums[leftIndex++];
		}

		while (rightIndex <= end) {
			temp[index++] = nums[rightIndex++];
		}

		for (int i = start; i <= end; i++) {
			nums[i] = temp[i];
		}
	}
}
