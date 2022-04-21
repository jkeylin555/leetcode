package Sort;

public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
		if (nums.length == 0 || nums == null) {
			return -1;
		}

		return quickSelect(nums, 0, nums.length - 1, k);
	}

	private int quickSelect(int[] nums, int start, int end, int k) {
		if (start >= end) {
			return nums[start];
		}

		int pivot = nums[(start + end) / 2];
		int left = start, right = end;
		while (left <= right) {
			while (left <= right && nums[left] > pivot) {
				left++;
			}
			while (left <= right && nums[right] < pivot) {
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

		if (k - 1 <= right) {
			return quickSelect(nums, start, right, k);
		}
		if (k - 1 >= left) {
			return quickSelect(nums, left, end, k);
		}

		return nums[right + 1];
	}

	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		KthLargestElement kthLargestElement = new KthLargestElement();
		System.out.println(kthLargestElement.findKthLargest(arr, 2));
	}
}
