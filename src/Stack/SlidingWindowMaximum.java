package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> monoStack = new ArrayDeque<>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			while (!monoStack.isEmpty() && nums[monoStack.peekLast()] < nums[i]) {
				int top = monoStack.pollLast();
			}
			if (!monoStack.isEmpty() && monoStack.peek() <= i - k) {
				monoStack.poll();
			}
			monoStack.offer(i);
			if (i >= k - 1) {
				res[i - k + 1] = nums[monoStack.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] matrix = {1,3,1,2,0,5};
		SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
		int[] res = slidingWindowMaximum.maxSlidingWindow(matrix, 3);
		for (int n : res) {
			System.out.println(n);
		}
	}
}
