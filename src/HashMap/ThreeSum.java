package HashMap;

import BFS.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 1 && nums[i] == nums[i - 1]) {
				continue;
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(nums[i], i);
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if (map.containsKey(-nums[i] - nums[j])) {
					int a = map.get(-nums[i] - nums[j]);
					results.add(Arrays.asList(nums[i], nums[j], nums[a]));
				} else {
					map.put(nums[j], j);
				}
			}
		}
		return results;
	}
	public static void main(String[] args) {
        int[] sum = {1,1,-2};
        Arrays.sort(sum);
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> result = threeSum.threeSum(sum);
//		HashMap<Integer, Integer> map = new HashMap<>();

//		result.add(Arrays.asList(1, 2, 3));
		System.out.println(result);
	}

}
