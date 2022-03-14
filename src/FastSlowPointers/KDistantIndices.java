package FastSlowPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDistantIndices {

	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List list = new ArrayList();
		int last = 0, fast = 0;
		Set<Integer> set = new HashSet();
		while (fast < nums.length) {
			if (nums[fast] == key) {
				int start = Math.max(0, fast - k), end = Math.min(fast + k, nums.length - 1);
				for (int i = start; i <= end; i++){
					if (set.add(i)) {
						list.add(i);
					};
				}
				fast = Math.min(fast + k, nums.length - 1);

			}
			fast++;

		}
	    return list;

	}
	public static void main(String[] args) {
		int[] array = {3,4,9,1,3,9,5};
		int[] array2 = {1};
		int[] array3 = {2,2,2,2,2};
		int[] array4 = {734,228,636,204,552,732,686,461,973,874,90,537,939,986,855,387,344,939,552,389,116,93,545,805,572,306,157,899,276,479,337,219,936,416,457,612,795,221,51,363,667,112,686,21,416,264,942,2,127,47,151,277,603,842,586,630,508,147,866,434,973,216,656,413,504,360,990,228,22,368,660,945,99,685,28,725,673,545,918,733,158,254,207,742,705,432,771,578,549,228,766,998,782,757,561,444,426,625,706,946};

		KDistantIndices kDistantIndices = new KDistantIndices();
		List list = kDistantIndices.findKDistantIndices(array4, 939, 34);
		System.out.println(list.toString());
	}
}
