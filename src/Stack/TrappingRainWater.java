package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
	public int trap(int[] height) {
		Deque<Integer> stack = new ArrayDeque<>();
		int leftMax = height[0];
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] >= stack.peek()) {
				int top = stack.pop();
				res += leftMax - top;
			}
			stack.push(height[i]);
			leftMax = Math.max(leftMax, height[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] duNums = {0,1,0,2,1,0,1,3,2,1,2,1};
		FastSlowPointers.TrappingRainWater trappingRainWater = new FastSlowPointers.TrappingRainWater();
		System.out.println(trappingRainWater.trap(duNums));
	}
}
