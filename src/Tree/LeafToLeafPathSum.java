package Tree;

import BFS.PrintBinaryTree;
import BFS.TreeNode;

public class LeafToLeafPathSum {
	static int max = Integer.MIN_VALUE;
	public int pathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = pathSum(root.left);
		int right = pathSum(root.right);
		if (root.left != null && root.right != null) {
			max = Math.max(max, left + root.val + right);
			return left > right ? left + root.val : right + root.val;
		} else {
			return root.left == null ? root.val + right : root.val + left;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
		root.right.left.left = new TreeNode(2);
		LeafToLeafPathSum leafToLeafPathSum = new LeafToLeafPathSum();
		leafToLeafPathSum.pathSum(root);
		System.out.println(max);
	}
}
