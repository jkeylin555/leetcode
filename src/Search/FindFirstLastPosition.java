package Search;

public class FindFirstLastPosition {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return new int[] {-1, -1};
		}

		int leftIndex = binarySearch(nums, 0, nums.length - 1, target, true);
		int rightIndex = binarySearch(nums, 0, nums.length -1, target, false);

		if (leftIndex == - 1 || rightIndex == -1) {
			return new int[] {-1, -1};
		}

		return new int[] {leftIndex, rightIndex};
	}

	private int binarySearch(int[] nums, int start, int end, int target, boolean isFirstSearch) {
		int leftIndex = start, rightIndex = end;
		while (leftIndex + 1 < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			if (nums[mid] == target) {
				if (isFirstSearch) {
					rightIndex = mid;
				} else {
					leftIndex = mid;
				}
			} else if (nums[mid] > target) {
				rightIndex = mid;
			} else {
				leftIndex = mid;
			}
		}

		if (isFirstSearch) {
			if (nums[leftIndex] == target) {
				return leftIndex;
			}
			if (nums[rightIndex] == target) {
				return rightIndex;
			}
		}
		if (nums[rightIndex] == target) {
			return rightIndex;
		}
		if (nums[leftIndex] == target) {
			return leftIndex;
		}

		return -1;
	}
}
