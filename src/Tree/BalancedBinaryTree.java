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
}
