package Math;

import Stack.TrappingRainWater;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majority(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.size() == 0) {
				map.put(nums[i], 1);
			} else if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
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
			}
			if (nums[i] == major) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}




	public static void main(String[] args) {
		int[] duNums = {2,2,1,1,1,2,2};
		int[] duNums2 = {3,2,3};
		MajorityElement majorityElement = new MajorityElement();
		System.out.println(majorityElement.majority2(duNums2));
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
