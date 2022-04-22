package Search;

public class MaximumofSequence {
	public int mountainSequence(int[] nums) {
		// write your code here
		if (nums.length == 0 || nums == null) {
			return -1;
		}

		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (mid < end && nums[mid] <= nums[mid + 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return nums[end] >= nums[start] ? nums[end] : nums[start];
	}
}
