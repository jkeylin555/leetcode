package Tree;

import BFS.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class TreeToDoubleLinkedList {
	static TreeNode pre = null, head = null;
	public void treeToDLL(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (head == null) {
			head = root;
			pre = root;
			root.left = null;
		} else {
			root.left = null;
			pre.right = root;
			pre = root;
		}

		treeToDLL(left);

		treeToDLL(right);
	}

	public static void main(String[] args) {
		TreeToDoubleLinkedList treeToDoubleLinkedList = new TreeToDoubleLinkedList();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right= new TreeNode(4);
		root.right.right = new TreeNode(6);


		treeToDoubleLinkedList.treeToDLL(root);
		while (head != null) {
			System.out.println(head.val);
			System.out.println(head.left);
			head = head.right;
		}
	}
}
