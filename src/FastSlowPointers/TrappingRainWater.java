package FastSlowPointers;

public class TrappingRainWater {
	public int trap(int[] height) {
		int left = 0, right = height.length - 1;
		int leftMax = Integer.MIN_VALUE;
//		int rightMax = Integer.MIN_VALUE;
		int res = 0;
		while (left < right) {
			if (height[left] <= height[right]) {
				leftMax = Math.max(leftMax, height[left]);
				res += leftMax - height[left];
				left++;
			} else {
				leftMax = Math.max(leftMax, height[right]);
				res += leftMax - height[right];
				right--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] duNums = {0,1,0,2,1,0,1,3,2,1,2,1};
		TrappingRainWater trappingRainWater = new TrappingRainWater();
		System.out.println(trappingRainWater.trap(duNums));
	}
}
