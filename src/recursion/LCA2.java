package recursion;

import BFS.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class LCA2 {
	public TreeNode LCA2(TreeNode root, Set set) {
		if (root == null || set.contains(root)) {
			return root;
		}
		TreeNode left = LCA2(root.left, set);
		TreeNode right = LCA2(root.right, set);

		if (left != null && right != null) {
			return root;
		}

		return left == null ? right:left;
	}

	public static void main(String[] args) {
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5));
		root2.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

		LCA2 lca2 = new LCA2();
		Set<TreeNode> set = new HashSet<>();
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		set.add(a);
//		set.add(b.val);
		set.add(c);
		set.add(d);
		TreeNode treeNode = lca2.LCA2(root2, set);
		System.out.println(treeNode.val);
	}
}
