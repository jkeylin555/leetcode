package Search;

import Sort.KthLargestElement;

public class MedianOfTwoArrays {
	public int findMedianSortedArrays(int[] nums1, int left1,  int[] nums2, int left2, int k) {
		if (left1 > nums1.length - 1) {
			return nums2[left2 + k - 1];
		}
		if (left2 > nums2.length - 1) {
			return nums1[left1 + k - 1];
		}
		if (k == 1) {
			return nums1[left1] < nums2[left2] ? nums1[left1] : nums2[left2];
		}

		if (left1 + k/2 - 1> nums1.length - 1) {
			return findMedianSortedArrays(nums1, left1, nums2, left2 + k/2, k - k/2);
		}
		if (left2 + k/2 - 1> nums2.length - 1) {
			return findMedianSortedArrays(nums1, left1 + k/2, nums2, left2 , k - k/2);
		}

//		if (nums1[left1 + k/2 - 1] == nums2[left2 + k/2 - 1]) {
//			return nums1[left1 + (k - 1)/2];
//		}
//		else
			if (nums1[left1 + k/2 - 1] < nums2[left2 + k/2 - 1]) {
			return findMedianSortedArrays(nums1, left1 + k/2, nums2, left2, k - k/2);
		} else {
			return findMedianSortedArrays(nums1, left1, nums2, left2 + k/2, k - k/2);
		}
	}

}
