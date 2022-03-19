package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubsetsUnique {
	static public List<List<Integer>> results = new ArrayList<>();
	public void subsets(int[] nums, int level, LinkedList<Integer> list) {
		if (level == nums.length) {
			results.add(new ArrayList<>(list));
			return;
		}

		list.add(nums[level]);
		subsets(nums, level + 1, list);
		list.removeLast();
		while (level < nums.length - 1 && nums[level + 1] == nums[level]) {
			level++;
		}
		subsets(nums, level + 1, list);
	}
}
