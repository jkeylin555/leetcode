package Sort;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
		return quickSort(nums, 0, nums.length - 1, k);
	}
	public int quickSort(int[] nums, int left, int right, int k) {
		int index = randomPartition(nums, left, right);
		if (index == k - 1) {
			return nums[index];
		} else if (index > k - 1) {
			return quickSort(nums, left, index - 1, k);
		} else {
			return quickSort(nums, index + 1, right, k);
		}
	}
	public int randomPartition(int[] nums, int left, int right) {
		Random rand = new Random();
		int random = rand.nextInt(right - left + 1) + left;
		swap(nums, random, right);
		return partion(nums, left, right);
	}
	private int partion(int[] nums, int left, int right) {
		int pivot = right;
		while (left <= right) {
			while (left <= right && nums[right] <= nums[pivot]) {
				right--;
			}
			while (left <= right && nums[left] > nums[pivot]) {
				left++;
			}
			if (right >= left) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		swap(nums, right + 1, pivot);
		return right + 1;
	}
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int[] nums2 = {3,2,1,4,6,5};
		KthLargestElement kthLargestElement = new KthLargestElement();
//		kthLargestElement.partion(nums2, 0 , 5);
		System.out.println(kthLargestElement.findKthLargest(nums, 3));
	}
}
