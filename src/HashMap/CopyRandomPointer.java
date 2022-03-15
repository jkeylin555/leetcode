package HashMap;

import BFS.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointer {
	private ListNode randomPointer(ListNode head) {
		if (head == null) {
			return null;
		}
		Map<ListNode, ListNode> map = new HashMap<>();
		ListNode newHead = new ListNode(head.val);
		ListNode curNode = newHead;
		map.put(head, curNode);
		while (head != null) {
			ListNode newRandom;
			if (head.random != null) {
				if (map.get(head.random) != null) {
					curNode.random = map.get(head.random);
				} else {

					newRandom = new ListNode(head.random.val);
					curNode.random = newRandom;
					map.put(head.random, curNode.random);
				}
			}
            if (head.next != null) {
				if (map.get(head.next) != null) {
					curNode.next = map.get(head.next);
				} else {
					ListNode newNext = new ListNode(head.next.val);
					curNode.next = newNext;
					map.put(head.next, curNode.next);
				}
			}

			head = head.next;

			curNode = curNode.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(7);
		node.next = new ListNode(13);
		node.random = null;
		node.next.next = new ListNode(11);
		node.next.random = new ListNode(7);
		node.next.next.next = new ListNode(10);
		node.next.next.random = new ListNode(1);
		node.next.next.next.next = new ListNode(1);
		node.next.next.next.random = new ListNode(11);
		node.next.next.next.next.next = null;
		node.next.next.next.next.random = new ListNode(7);
		CopyRandomPointer copyRandomPointer = new CopyRandomPointer();
		ListNode result = copyRandomPointer.randomPointer(node);
		System.out.println(result.val);
//		Map<ListNode, ListNode> node2 = new HashMap();
//		ListNode node3 = null;
//		ListNode node4 = null;
//		ListNode node5 = null;
//		node2.put(null, null);
//		System.out.println(node2.get(null));

	}

}
