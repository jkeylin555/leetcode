package HashMap;

public class ListNode {
	int val;
	ListNode next;
	ListNode random;
	public ListNode(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

//No Override Here!!!
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj instanceof ListNode) {
//			ListNode node = (ListNode) obj;
//			return this.val == node.val;
//		}
//		return false;
//	}
//	@Override
//	public int hashCode() {
//		return val * 31;
//	}

}
