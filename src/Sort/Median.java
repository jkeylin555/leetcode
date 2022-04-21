package Sort;

public class Median {
	/**
	 * @param nums: A list of integers
	 * @return: An integer denotes the middle number of the array
	 */
	public int median(int[] nums) {
		// write your code here
		if (nums.length == 0 || nums == null) {
			return -1;
		}

		return quickSelect(nums, 0, nums.length - 1, (nums.length - 1) / 2);
	}

	private int quickSelect(int[] nums, int start, int end, int k) {
		if (start >= end) {
			return nums[start];
		}

		int pivot = nums[(start + end) / 2];
		int left = start, right = end;
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

		if (k <= right) {
			return quickSelect(nums, start, right, k);
		}
		if (k >= left) {
			return quickSelect(nums, left, end, k);
		}

		return nums[right + 1];
	}

}
