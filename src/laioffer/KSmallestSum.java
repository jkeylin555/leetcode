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
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Element) {
				Element element = (Element) obj;
				return this.x == element.x && this.y == element.y && this.sum == element.sum;
			}
			return false;
		}

		@Override
		public int hashCode(){
			return x * 31 + y;
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
		//Element is self defined, so it will be overrided (both in equals and hashCode) so that it can work.
		Element element1 = new Element(1, 2, 3);
		Element element2 = new Element(1, 2, 3);
		Element element3 = new Element(0, 1, 2);
		Element element4 = new Element(1, 2, 4);
		Set<Element> set = new HashSet<Element>();
		Set<Integer> set2 = new HashSet<Integer>();

		PriorityQueue<Element> minheap2 = new PriorityQueue<Element>(4);
		minheap2.offer(element1);
		minheap2.offer(element2);
		minheap2.offer(element3);
		minheap2.offer(element4);
		System.out.println(minheap2.peek());
		System.out.println(set.add(element1));
		System.out.println(set.add(element2));
		//Integer has overrided(both equals and hashCode
		Integer integer1 = 1000;
		Integer integer2 = 1000;

		System.out.println(set2.add(integer1));
		System.out.println(set2.add(integer2));

		KSmallestSum kSmallestSum = new KSmallestSum();
		int result = kSmallestSum.kSmallestSum(A, B, 8);
		System.out.println(result);
	}
}
