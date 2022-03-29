package BitNumber;

import DP.TrappingRainWater;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int res = 0;
		for (int c : nums) {
			res = res^c;
		}
		for (int i = 0; i <= nums.length; i++) {
			res = res^i;
		}
		return res;
	}
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);

//		int[] duNums = {9,6,4,2,3,5,7,0,1};
//		for (int n : list) {
//			System.out.println(n);
//		}
		char c = 'c';
		System.out.println(c - 'a');
//		MissingNumber missingNumber = new MissingNumber();
//		System.out.println(missingNumber.missingNumber(duNums));
//		System.out.println(missingNumber.missingNumber(duNums));
	}
}
