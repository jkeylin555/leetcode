package FastSlowPointers;

public class TrappingRainWater {
	public int trap(int[] heights) {
		int left = 0, right = heights.length - 1;
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		int res = 0;
		while (left < right) {
			if (heights[left] <= heights[right]) {
				leftMax = Math.max(leftMax, heights[left]);
				res += leftMax - heights[left];
				left++;
			} else {
				rightMax = Math.max(rightMax, heights[right]);
				res += rightMax - heights[right];
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
