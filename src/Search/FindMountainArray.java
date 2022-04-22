package Search;

import java.util.ArrayList;
import java.util.List;

public class FindMountainArray {
	public int findInMountainArray(int target, List<Integer> list) {
		if (list.size() == 0) {
			return -1;
		}


		int peekIndex = findPeekOfMountain(target, list);
		int leftIndex = -1, rightIndex = -1;
		if (list.get(peekIndex) >= target) {
			leftIndex = binarySearch(target, list, 0, peekIndex);
			rightIndex = binarySearch(target, list, peekIndex, list.size() - 1);
		} else {
			return -1;
		}

		return leftIndex > -1 ? leftIndex : rightIndex;
	}


	private int binarySearch(int target, List<Integer> list, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (list.get(mid) == target) {
				return mid;
			}
			if (list.get(mid) > target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;


	}

	private int findPeekOfMountain(int target, List<Integer> list) {
		int start = 0, end = list.size() - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (list.get(mid) <= list.get(mid + 1)) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return list.get(end) >= list.get(start) ? end:start;
	}

	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {1,5,2};
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(2);
		FindMountainArray findMountainArray = new FindMountainArray();
//		kthLargestElement.partion(nums2, 0 , 5);
		System.out.println(findMountainArray.findInMountainArray(2, list));
	}

}
