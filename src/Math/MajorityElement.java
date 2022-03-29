package Math;

import Stack.TrappingRainWater;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	public int majority(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else if (map.size() < k - 1) {
				map.put(nums[i], 1);
			} else {
				Map.Entry<Integer,Integer> entry = map.entrySet().iterator().next();
				int key = entry.getKey();
				map.put(key, map.get(key) - 1);
			}
		}
		Map.Entry<Integer,Integer> entry = map.entrySet().iterator().next();
		return entry.getKey();
	}


	public int majority2(int[] nums) {
		int major = -1, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				major = nums[i];
			} else if (nums[i] == major) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}

	public List<Integer> majority3(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int major1 = -1, major2 = -1, count1 = 0, count2 = 0;
		for (int i = 0; i < nums.length; i++) {

			if (major1 == nums[i]) {
				count1++;
			} else if (major2 == nums[i]) {
				count2++;
			}else if (count1 == 0) {
				major1 = nums[i];
				count1++;
			} else if (count2 == 0) {
				major2 = nums[i];
				count2++;
			} else {
				count1--;
				count2--;
			}

		}
		count1 = 0;count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == major1) {
				count1++;
			}
			if (nums[i] == major2) {
				count2++;
			}
		}
		if ((float)count1/nums.length > (float)1/3) {
			res.add(major1);
		}

		if ((float)count2/nums.length > (float)1/3 && major1 != major2) {
			res.add(major2);
		}
		return res;
	}




	public static void main(String[] args) {
		int[] duNums = {2,1,1,3,1,4,5,6};
		int[] duNums2 = {3,2,3};
		MajorityElement majorityElement = new MajorityElement();
		System.out.println(majorityElement.majority3(duNums));
//		System.out.println((float)(1/3));
//		Map<String,Integer> map = new HashMap<>();
//		map.put("aaa", 1);
//		Map.Entry<String,Integer> entry = map.entrySet().iterator().next();
//		String key = entry.getKey();
//		map.put(key, map.get(key) - 1);
//		String key2 = entry.getKey();
//		int value2 = entry.getValue();
//		System.out.println(key2);
//		System.out.println(value2);

	}
}
