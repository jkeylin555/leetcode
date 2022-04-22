package Search;

public class FindKClosestElements {
	public int[] kClosestNumbers(int[] a, int target, int k) {
			// write your code here
			if (k == 0) {
				return new int[] {};
			}

			int leftIndex = 0, rightIndex = a.length - 1;
			while (leftIndex + 1 < rightIndex) {
				int mid = leftIndex + (rightIndex - leftIndex) / 2;
				if (a[mid] < target) {
					leftIndex = mid;
				} else {
					rightIndex = mid;
				}
			}

			int[] res = new int[k];
			int closeIndex = -1, closeNum = 0, resIndex = 0;
			if (Math.abs(a[leftIndex] - target) <= Math.abs(a[rightIndex] - target)) {
				closeIndex = leftIndex;
			} else {
				closeIndex = rightIndex;
			}
			res[resIndex++] = a[closeIndex];


			int closeLeft = closeIndex - 1, closeRight = closeIndex + 1, kLeft = k - 1;
			while (closeLeft >= 0 && closeRight <= a.length - 1 && kLeft > 0) {
				if (Math.abs(a[closeLeft] - target) <= Math.abs(a[closeRight] - target)) {
					res[resIndex++] = a[closeLeft];
					closeLeft--;
				} else {
					res[resIndex++] = a[closeRight];
					closeRight++;
				}
				kLeft--;
			}

			while (closeLeft >= 0 && kLeft > 0) {
				res[resIndex++] = a[closeLeft];
				closeLeft--;
				kLeft--;
			}

			while (closeRight <= a.length - 1 && kLeft > 0) {
				res[resIndex++] = a[closeRight];
				closeRight++;
				kLeft--;
			}

			return res;
		}
	public static void main(String[] args) {
		int[] nums2 = {1,4,6,8};
		FindKClosestElements findKClosestElements = new FindKClosestElements();
//		kthLargestElement.partion(nums2, 0 , 5);
		int[] res = findKClosestElements.kClosestNumbers(nums2, 3,  3);
		for (int n : res) {
			System.out.print(n);
		}

	}
}
