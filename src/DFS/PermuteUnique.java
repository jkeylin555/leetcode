package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PermuteUnique {
	static List<List<Integer>> results = new ArrayList<>();
	public void permute(int[] nums, int level) {
		if (level == nums.length) {
			results.add(new ArrayList(Arrays.stream(nums).boxed().collect(Collectors.toList())));
		}
		Set<Integer> set = new HashSet<>();
		for (int i = level; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
				swap(nums, i, level);
				permute(nums, level + 1);
				swap(nums, i, level);
			}
		}
	}
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,2,2};
		Arrays.sort(nums);
		String[] geeks = {"Rahul", "Utkarsh",
				"Shubham", "Neelam"};

        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
		PermuteUnique permuteUnique = new PermuteUnique();
		permuteUnique.permute(nums, 0);
		System.out.println(results);
		System.out.println((int) Math.sqrt(8));
	}
}
