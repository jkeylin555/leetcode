package Sort;

public class QuickSort {
	public void quickSort(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return;
		}

		sortIntegers(nums, 0, nums.length - 1);
	}

	private void sortIntegers(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		int left = start, right = end;
		int pivot = nums[(left + right) / 2];
		while (left <= right) {
			while (left <= right && nums[left] < pivot) {
				left++;
			}
			while (left <= right && nums[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}

		sortIntegers(nums, start, right);
		sortIntegers(nums, left, end);
	}
}
