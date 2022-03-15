package recursion;

import BFS.TreeNode;

public class LCA {
	public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || root.val == a.val || root.val == b.val) {
			return root;
		}
		TreeNode left = LCA(root.left, a, b);
		TreeNode right = LCA(root.right, a, b);

		if (left != null && right != null) {
			return root;
		}

		return left == null ? right:left;
	}

	public static void main(String[] args) {
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		root2.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
		LCA lca = new LCA();
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(5);
		TreeNode treeNode = lca.LCA(root2, a, b);
		System.out.println(treeNode.val);
	}
}
