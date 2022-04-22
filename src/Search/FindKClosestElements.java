package Search;

public class FindKClosestElements {
	public int[] kClosestNumbers(int[] a, int target, int k) {
			// write your code here
			if (k == 0) {
				return new int[] {};
			}

			int right = findUpperCloset(a, target);
			int left = right - 1;
			int index = 0;
			int[] res = new int[k];
			for (int i = 0; i < k; i++) {
				if (isLeftCloser(a, target, left, right)) {
					res[index++] = a[left];
					left--;
				} else {
					res[index++] = a[right];
					right++;
				}
			}
			return res;
		}

		private boolean isLeftCloser(int[] nums, int target, int left, int right) {
			if (left < 0) {
				return false;
			}
			if (right >= nums.length) {
				return true;
			}
			return target - nums[left] < nums[right] - target;
		}

		private int findUpperCloset(int[] nums, int target) {
			int start = 0, end = nums.length - 1;
			while (start + 1 < end) {
				int mid = start + (end - start) / 2;
				if (nums[mid] < target) {
					start = mid;
				} else {
					end = mid;
				}
			}

			if (nums[start] >= target) {
				return start;
			}
			if (nums[end] >= target) {
				return end;
			}

			return nums.length;
		}
	public static void main(String[] args) {
		int[] nums2 = {1,4,6,8};
		FindKClosestElements findKClosestElements = new FindKClosestElements();
		int[] res = findKClosestElements.kClosestNumbers(nums2, 3,  3);
		for (int n : res) {
			System.out.print(n);
		}

	}
}
