package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[] {};
	}


	public int[] twoSum2(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				return new int[] {left, right};
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] {};
	}


}
