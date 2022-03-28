package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
	public int trap(int[] height) {
		Deque<Integer> stack = new ArrayDeque<>();
		int leftMax = height[0];
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int upperHeight = Math.min(height[stack.peek()], height[i]);
				int heightDiff = upperHeight - height[top];
				res += heightDiff * (i - stack.peek() - 1);
			}
			stack.push(i);
			leftMax = Math.max(leftMax, height[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] duNums = {4,2,0,7,2,5};
		TrappingRainWater trappingRainWater = new TrappingRainWater();
		System.out.println(trappingRainWater.trap(duNums));
	}
}
