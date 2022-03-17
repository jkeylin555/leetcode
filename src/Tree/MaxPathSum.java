package Tree;

import BFS.TreeNode;
import jdk.jshell.spi.SPIResolutionException;

public class MaxPathSum {
	//注意 max 这里static的用法 这里需要static申明  但是leetcode上必须删掉 否则有问题
	static int maxValue = Integer.MIN_VALUE;
	private int pathSum(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		int left = pathSum(root.left, max);
		int right = pathSum(root.right, max);
		left = Math.max(left, 0);
		right = Math.max(right, 0);
		max = Math.max(root.val + left + right, max);
		return Math.max(left, right) + root.val;
	}

	private void pathSum2(TreeNode root, int max, int prefix) {
		if (root == null) {
			return;
		}
		prefix = Math.max(prefix, 0) + root.val;
		maxValue = Math.max(maxValue, prefix);

		pathSum2(root.left, max, prefix);
		pathSum2(root.right, max, prefix);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);

//		root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
//		root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
//		root.right.left.left = new TreeNode(2);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int max = Integer.MIN_VALUE;
		MaxPathSum maxPathSum = new MaxPathSum();
		maxPathSum.pathSum2(root, max, 0);
		if (root == null) {
			System.out.println(0);
		} else {
			System.out.println(maxValue);
		}
	}
}
