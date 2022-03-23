package BFS2;

import HashMap.ThreeSum;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.plaf.IconUIResource;

public class KthCloseToPoint {
	public Element closest(int[] a, int[] b, int[] c, int k) {
		PriorityQueue<Element> priorityQueue = new PriorityQueue<Element>(new Comparator<Element>() {
			@Override
			public int compare(Element e1, Element e2) {
				if (e1.distance == e2.distance) return 0;
				return e1.distance < e2.distance ? -1 : 1;
			}
		});
		int i = 0, j = 0, t = 0, count = 0, distance = Integer.MAX_VALUE;
		priorityQueue.add(new Element(a[i], b[j], c[t]));
		Element top = null;
		while (!priorityQueue.isEmpty() && count < k) {
			top = priorityQueue.poll();
			distance = top.distance;
			if (i + 1 < a.length) {
				priorityQueue.offer(new Element(a[++i], b[j], c[t]));
			}
			if (j + 1 < b.length) {
				priorityQueue.offer(new Element(a[i], b[++j], c[t]));
			}
			if (k + 1 < c.length) {
				priorityQueue.offer(new Element(a[++i], b[j], c[++k]));
			}
			count++;
		}
		return top;

	}
	class Element {
		int x, y, z, distance;
		public Element(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.distance = x^2 + y^2 + z^2;
		}
	}


	public static void main(String[] args) {
		int A[] = {1, 3, 5}, B[] = {2, 4}, C[] = {3, 6};
		KthCloseToPoint kthCloseToPoint = new KthCloseToPoint();
        Element result = kthCloseToPoint.closest(A,B,C,3);
		System.out.println(result.x);
		System.out.println(result.y);
		System.out.println(result.z);
	}
}
