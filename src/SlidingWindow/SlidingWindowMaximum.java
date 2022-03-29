package SlidingWindow;

import Search.MedianOfTwoArrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    class Element {
    	int index;
    	int value;
    	Element (int index, int value) {
    		this.index = index;
    		this.value = value;
		}
	}


	public int[] maxSlidingWindow(int[] nums, int k) {
		PriorityQueue<Element> maxHeap = new PriorityQueue<>(new Comparator<Element>() {
			@Override
			public int compare(Element e1, Element e2) {
				if (e1.value == e2.value) return 0;
				return e1.value > e2.value ? -1 : 1;
			}
		});
		int[] res = new int[nums.length - k + 1];

		for (int i = 0; i < k; i++) {
			maxHeap.offer(new Element(i, nums[i]));
		}
        int j = 0;
		res[j++] = maxHeap.peek().value;
		for (int i = k; i < nums.length; i++) {
			while (!maxHeap.isEmpty() && maxHeap.peek().index + k <= i && maxHeap.peek().value > nums[i]) {
				maxHeap.poll();
			}
			maxHeap.offer(new Element(i, nums[i]));
			res[j++] = maxHeap.peek().value;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,-1};
		SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
		int[] res = slidingWindowMaximum.maxSlidingWindow(nums1, 1);
		for (int n : res) {
			System.out.println(n);
		}
	}
}
