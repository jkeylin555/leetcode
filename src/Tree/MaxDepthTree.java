package Tree;

import BFS.TreeNode;

public class MaxDepthTree {
	private int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getMaxDepth(root.left);
		int right = getMaxDepth(root.right);
		return Math.max(left, right) + 1;
	}
}
