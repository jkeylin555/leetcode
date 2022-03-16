package Tree;

import BFS.TreeNode;

public class InsertIntoBST {
	private TreeNode insertIntoBST (TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		}
		if (root.val < val) {
			root.right = insertIntoBST(root.right, val);
		}
		return root;

	}

	private TreeNode insertIntoBST2 (TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		TreeNode curNode = root;
		TreeNode pre = null;
		while (curNode != null) {
			pre = curNode;
			if (curNode.val > val) {
				curNode = curNode.left;
			} else if (curNode.val < val) {
				curNode = curNode.right;
			} else {
				break;
			}
		}
		if (pre.val > val) {
			pre.left = new TreeNode(val);
		}
		if (pre.val < val) {
			pre.right = new TreeNode(val);
		}
		return root;
	}
}
