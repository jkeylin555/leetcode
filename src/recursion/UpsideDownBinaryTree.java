package recursion;

import BFS.TreeNode;
import Tree.TargetPathSum;
import java.util.HashSet;
import java.util.Set;

public class UpsideDownBinaryTree {
	public TreeNode reverse(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode down = reverse(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
        return down;
	}

	public static void main(String[] args) {
		UpsideDownBinaryTree upsideDownBinaryTree = new UpsideDownBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode result = upsideDownBinaryTree.reverse(root);
		System.out.println(result.val);
	}

}
