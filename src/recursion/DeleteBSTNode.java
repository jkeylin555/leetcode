package recursion;

import BFS.TreeNode;

public class DeleteBSTNode {
	public TreeNode deleteNode (TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
			return root;
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
			return root;
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null || root.right == null) {
				return root.left == null ? root.right : root.left;
			} else {
				int smallest = findSmallestNode(root.right);
				root.val = smallest;
				root.right = deleteNode(root.right, smallest);
				return root;
			}
		}
	}
	private int findSmallestNode (TreeNode treeNode) {
		if (treeNode == null) {
			return Integer.MIN_VALUE;
		}
		while (treeNode.left != null) {
			treeNode = treeNode.left;
		}
		return treeNode.val;
	}
}
