package Tree;

import BFS.TreeNode;

public class MaxPathSum {
	//注意 max 这里static的用法 这里需要static申明  但是leetcode上必须删掉 否则有问题
	static int max = Integer.MIN_VALUE;
	private int pathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = pathSum(root.left);
		int right = pathSum(root.right);

		if (left >= 0 && right >= 0) {
			max = Math.max(root.val + left + right, max);
			return Math.max(left, right) + root.val;
		} else if (left >= 0 || right >= 0) {
			max = Math.max(root.val + Math.max(left, right), max);
			return root.val + Math.max(left, right);
		} else {
			max = Math.max(root.val, max);
			return root.val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = null;

//		root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
//		root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
//		root.right.left.left = new TreeNode(2);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
//		MaxPathSum maxPathSum = new MaxPathSum();
//		maxPathSum.pathSum(root);
		if (root == null) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}
	}
}
