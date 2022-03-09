//package laioffer;
//
//import java.lang.annotation.ElementType;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.PriorityQueue;
//import java.util.Set;
//import javax.lang.model.element.Element;
//
//public class KSmallestSum {
//	public int kSmallestSum(int[] A, int[] B, int k) {
//		Set<Integer> set = new HashSet<>();
//		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if (o1.intValue() == o2.intValue()) return 0;
//				return o1 < o2 ? -1:1;
//			}
//		});
//
//
//
//	}
//}
