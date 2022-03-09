package laioffer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KSmallestSum {
	static class Element{
		int sum, x, y;
		public Element(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}
	public int kSmallestSum(int[] A, int[] B, int k) {
		Set<Element> set = new HashSet<>();
		PriorityQueue<Element> minheap = new PriorityQueue<Element>(k, new Comparator<Element>() {
			@Override
			public int compare(Element o1, Element o2) {
				if (o1.sum == o2.sum) return 0;
				return o1.sum < o2.sum ? -1:1;
			}
		});
		int result = A[0] + B[0];
		Element cur = new Element( 0, 0, A[0] + B[0]);
		minheap.offer(cur);
		for (int i = 0; i < k; i++) {
			cur = minheap.poll();
			result = cur.sum;
			if(cur.x < A.length - 1) {
				Element element = new Element(cur.x + 1, cur.y, A[cur.x + 1] + B[cur.y]);
				if (set.add(element)) {
					minheap.offer(element);
				}
			}
			if(cur.y < B.length - 1) {
				Element element = new Element(cur.x, cur.y + 1, A[cur.x] + B[cur.y + 1]);
				if (set.add(element)) {
					minheap.offer(element);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] A = {1, 7, 11};
		int[] B = {2, 4, 6};
		KSmallestSum kSmallestSum = new KSmallestSum();
		int result = kSmallestSum.kSmallestSum(A, B, 3);
		System.out.println(result);
	}
}
