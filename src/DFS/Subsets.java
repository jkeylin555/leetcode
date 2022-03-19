package DFS;

import HashMap.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
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

	public void subsets2(int[] nums, int level, LinkedList<Integer> list, int k, List<List<Integer>> results) {
		if (level == nums.length ) {
			if (list.size() == k) {
				results.add(new ArrayList<>(list));
			}
			return;
		}
		list.add(nums[level]);
		subsets2(nums, level + 1, list, k, results);
		list.removeLast();
		subsets2(nums, level + 1, list, k, results);
	}

	public static void main(String[] args) {
		int[] duNums = {2,1,2};
		Arrays.sort(duNums);
		int[] a = new int[10];
		int n = 4;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		LinkedList<Integer> list = new LinkedList<>();
		Subsets subsets = new Subsets();
		List<List<Integer>> results2 = new ArrayList<>();
//		subsets.subsets2(nums, 0, list, 2, results);
		subsets.subsets(duNums, 0, list);
		System.out.println(results);
	}
}
