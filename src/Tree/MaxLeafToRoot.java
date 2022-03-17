package Tree;

import BFS.TreeNode;
import HashMap.ListNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxLeafToRoot {

	private int maxPath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxPath(root.left);
		int right = maxPath(root.right);
		return root.val + Math.max(left, right);
	}

	private void allPath(TreeNode root, LinkedList<TreeNode> prefix, List<List<TreeNode>> results) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			prefix.add(root);
			results.add(new ArrayList<>(prefix));
			prefix.removeLast();
			return;
		}
		prefix.add(root);
		allPath(root.left, prefix, results);
		allPath(root.right, prefix, results);
		prefix.removeLast();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);

//		root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
//		root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
//		root.right.left.left = new TreeNode(2);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		LinkedList<TreeNode> prefix = new LinkedList<>();
		List<List<TreeNode>> results = new LinkedList<>();
		MaxLeafToRoot maxPathSum = new MaxLeafToRoot();
		maxPathSum.allPath(root,prefix, results);
//		System.out.println(results.toString());
		System.out.println("[");

		for (List<TreeNode> list : results) {
			System.out.print("  [");

			for (TreeNode item : list) {
				System.out.print("  "
						+ item.val
						+ ", ");
			}
			System.out.println("] ");
		}
		System.out.println("]");

	}


}
