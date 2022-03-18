package LinkedList;

import BFS.TreeNode;
import HashMap.ListNode;
import laioffer.LinkedList;

public class ReverseLinkedListPair {
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode next = null, node;
		if (head.next == null) {
			next = head.next;
			node = head;
		} else {
			next = head.next.next;
			node = head.next;
		}
	    node.next = head;
		head.next = reverse(next);
		return node;
	}


	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(7);

		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		ReverseLinkedListPair reverseLinkedListPair = new ReverseLinkedListPair();
		ListNode node = reverseLinkedListPair.reverse(listNode1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
