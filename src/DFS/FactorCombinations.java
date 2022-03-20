package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {
	static List<List<Integer>> results = new ArrayList<>();
	public void getFactors(float n, List<Integer> nums, int level,  LinkedList<Integer> preList) {
		if (n == 1.0) {
			results.add(new ArrayList<>(preList));
			return;
		}
		if (level == nums.size()) {
			return;
		}
		int h = 0;
		while (Math.pow(nums.get(level), h) <= n) {
			h++;
		}
		h--;

		for (int i = h; i >= 0; i--) {
			for (int k = 0; k < i; k++) {
				preList.add(nums.get(level));
			}
			int divide = i == 0 ? 1 : (int) Math.pow(nums.get(level), i);
			if (divide <= n) {
				getFactors((float) n / divide, nums,level + 1, preList);
			}
			for (int k = 0; k < i; k++) {
				preList.removeLast();
			}
		}

	}
	public static void main(String[] args) {
		int n = 12;
		List<Integer> nums = new ArrayList<>();
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				nums.add(i);
			}
		}
		LinkedList<Integer> list = new LinkedList<>();
		Collections.sort(nums, Collections.reverseOrder());
		FactorCombinations factorCombinations = new FactorCombinations();
		factorCombinations.getFactors(12, nums, 0, list);


		System.out.println(results);
	}
}
