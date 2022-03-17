package Tree;

import BFS.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalancedBT(TreeNode root) {
		int left = MaxDepthTree.getMaxDepth(root.left);
		int right = MaxDepthTree.getMaxDepth(root.right);
		if (Math.abs(right - left) <= 1) {
			return isBalancedBT(root.left) && isBalancedBT(root.right);
		} else {
			return false;
		}
	}


	public int isBalancedBT2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = isBalancedBT2(root.left);
		int right = isBalancedBT2(root.right);
		if (left < 0 || right < 0 || Math.abs(right - left) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}
}
