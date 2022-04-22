package Search;

public class SearchRotatedArray {
	public int search(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return -1;
		}

		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				if (nums[start] <= target && target <= nums[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				if (nums[mid] <= target && target <= nums[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}

		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}

		return -1;
	}
}
