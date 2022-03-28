package Stack;

import BFS2.KthCloseToPoint;
import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {
	public int largest(int[] heights) {
		Deque<Integer> monoStack = new ArrayDeque<>();
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {

			while (!monoStack.isEmpty() && heights[i] <= heights[monoStack.peek()]) {
				int top = monoStack.poll();
				int h = heights[top];
				int start = monoStack.isEmpty() ? -1 : monoStack.peek();
				maxArea = Math.max(maxArea, h * (i - start - 1));
			}
			monoStack.push(i);
		}

		while (!monoStack.isEmpty()) {
			int top = monoStack.poll();
			int h = heights[top];
			int start = monoStack.isEmpty() ? -1 : monoStack.peek();
		    maxArea = Math.max(maxArea, h * (heights.length - start -1));
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
		int res = largestRectangleHistogram.largest(heights);
		System.out.println(res);
	}

}
