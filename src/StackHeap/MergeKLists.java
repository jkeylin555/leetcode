package StackHeap;

import HashMap.ListNode;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
	private static class MergeNode {
		int indexOfArray;
		ListNode head;
//		int val;
		public MergeNode (int indexOfArray, ListNode head) {
			this.indexOfArray = indexOfArray;
			this.head = head;
//			this.val = val;
		}

	}
	private ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0 || lists == null) {
			return null;
		}
		PriorityQueue<MergeNode> minHeap = new PriorityQueue<>(new Comparator<MergeNode>() {
			@Override
			public int compare (MergeNode o1, MergeNode o2) {
				if (o1.head.val == o2.head.val) {
					return 0;
				}
				return o1.head.val < o2.head.val ? -1 : 1;
			}
		});
		for (int i = 0; i < lists.length; i++) {
			//IMPORTANT!!!!
			if (lists[i] != null) {
				minHeap.offer(new MergeNode(i, lists[i]));
			}

		}
		MergeNode curNode;
		ListNode dummyNode = new ListNode(0);
		ListNode pre = dummyNode;
		while (!minHeap.isEmpty()) {
			curNode = minHeap.poll();
			pre.next = curNode.head;
			pre = pre.next;
			if (curNode.head.next != null) {
				curNode.head = curNode.head.next;
				minHeap.offer(new MergeNode(curNode.indexOfArray, curNode.head));
			}
		}
		return dummyNode.next;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		node1.next = node2;
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);
		node3.next = node4;
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(6);
		node5.next =  node6;
		ListNode[] lists = {node1, node3, node5};
		ListNode[] lists2 = {null, null};
		MergeKLists mergeKLists = new MergeKLists();
		ListNode res = mergeKLists.mergeKLists(lists2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
