package recursion;

import BFS.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCA3 {
	public TreeNode2 LCA3(TreeNode2 root, TreeNode2 a, TreeNode2 b) {
		if (root == null || root.equals(a) || root.equals(b)) {
			return root;
		}
		int counter = 0;
		TreeNode2 temp = null;
		for(TreeNode2 child : root.children) {
			TreeNode2 node = LCA3(child, a, b);
			if (node != null) {
				counter++;
				if (counter == 2) {
					return root;
				}
				temp = node;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5));
		root2.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));



		LCA3 lca3 = new LCA3();
		Set<TreeNode> set = new HashSet<>();
		TreeNode2 a = new TreeNode2(4);
		TreeNode2 b = new TreeNode2(5);
		TreeNode2 c = new TreeNode2(8);
		TreeNode2 d = new TreeNode2(9);
		List<TreeNode2> treeNodeList = new ArrayList<>();
		treeNodeList.add(a);
		treeNodeList.add(b);
		treeNodeList.add(c);
		treeNodeList.add(d);

		TreeNode2 root = new TreeNode2(1, treeNodeList);

		TreeNode2 treeNode = lca3.LCA3(root, a, b);
		System.out.println(treeNode.val);

	}
}
