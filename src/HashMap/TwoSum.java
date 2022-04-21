package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
	class Pair implements Comparable<Pair> {
		int number, index;
		public Pair(int index, int number) {
			this.index = index;
			this.number = number;
		}

		public int compareTo(Pair other) {
			return this.number - other.number;
		}
	}

	public int[] twoSum(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return new int[]{-1, -1};
		}

		Pair[] pairs = getSortedPairs(nums);

		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (pairs[left].number + pairs[right].number < target) {
				left++;
			} else if (pairs[left].number + pairs[right].number > target) {
				right--;
			} else {
				return new int[]{pairs[left].index, pairs[right].index};
			}
		}

		return new int[] {-1, -1};

	}

	private Pair[] getSortedPairs(int[] nums) {
		Pair[] pairs = new Pair[nums.length];
		for (int i = 0; i < nums.length; i++) {
			pairs[i] = new Pair(i, nums[i]);
		}
		Arrays.sort(pairs);

		return pairs;
	}
//	public int[] twoSum(int[] nums, int target) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			if (map.containsKey(target - nums[i])) {
//				return new int[] {map.get(target - nums[i]), i };
//			} else {
//				map.put(nums[i], i);
//			}
//		}
//		return new int[] {};
//	}
//
//
//	public int[] twoSum2(int[] nums, int target) {
//		int left = 0, right = nums.length - 1;
//		while (left < right) {
//			if (nums[left] + nums[right] == target) {
//				return new int[] {left, right};
//			} else if (nums[left] + nums[right] < target) {
//				left++;
//			} else {
//				right--;
//			}
//		}
//		return new int[] {};
//	}




	public static void main(String[] args) {
//		Set<Integer> set = new HashSet<>();
//		Map<Integer, Integer> map =  new HashMap<>();
//		map.containsKey()
	}



}
