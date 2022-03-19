package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class Permutation {
	static List<List> lists = new ArrayList<>();
	int[][] results = new int[3][3];
	public void permute(int[] nums, int level) {
		if (level == 3) {
			lists.add(new ArrayList(Arrays.stream(nums).boxed().collect(Collectors.toList())));
			return;
		}

		for (int i = level; i < nums.length; i++) {
			swap(nums, i, level);
			permute(nums, level + 1);
			swap(nums, i, level);
		}

	}
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		String[] geeks = {"Rahul", "Utkarsh",
				"Shubham", "Neelam"};

		// Conversion of array to ArrayList
		// using Arrays.asList
//		Integer[] nums = (Integer) num;
//		List<Integer> list2 = new ArrayList<>();
//		List<Integer> list = Arrays.asList(nums);
//		list.add(Arrays.asList(1,2));
//		Lists.newArrayList(nums);
//		newa
//
//		List<String> l2 = Lists.newArrayList(aStringArray);


		Permutation permutation = new Permutation();
		permutation.permute(nums, 0);
		System.out.println(lists);
	}

}
