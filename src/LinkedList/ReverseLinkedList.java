package LinkedList;

import BFS.TreeNode;
import HashMap.ListNode;
import laioffer.LinkedList;

public class ReverseLinkedList {
	public ListNode reverse (ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;

		}
		return pre;
	}


	public ListNode reverse2 (ListNode head, ListNode pre) {
		if (head == null) {
			return pre;
		}
		ListNode next = head.next;
		head.next = pre;
		pre = head;
		ListNode result = reverse2(next, pre);
		return result;
	}


	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		ListNode node = reverseLinkedList.reverse2(listNode1, null);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}


	}

}





