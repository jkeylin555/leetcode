package BitNumber;

import DP.TrappingRainWater;

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
		int[] duNums = {9,6,4,2,3,5,7,0,1};
		MissingNumber missingNumber = new MissingNumber();
		System.out.println(missingNumber.missingNumber(duNums));
//		System.out.println(missingNumber.missingNumber(duNums));
	}
}
