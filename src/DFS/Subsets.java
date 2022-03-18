package DFS;

import HashMap.ListNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	static public List<List<Integer>> results = new ArrayList<>();
	public void subsets(int[] nums, int level, LinkedList<Integer> list) {
		if (level == 3) {
			results.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[level]);
		subsets(nums, level + 1, list);
		list.removeLast();
		subsets(nums, level + 1, list);
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};

		LinkedList<Integer> list = new LinkedList<>();
		Subsets subsets = new Subsets();
		subsets.subsets(nums, 0, list);
		System.out.println(results);
	}
}
