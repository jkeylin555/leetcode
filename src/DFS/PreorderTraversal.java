package DFS;

import BFS.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
	List<Integer> results= new ArrayList<>();
	public void preorderFun(TreeNode root) {
		if (root == null) {
			return;
		}
		results.add(root.val);
		preorderFun(root.left);
		preorderFun(root.right);
	}
}
