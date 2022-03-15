package recursion;

import BFS.TreeNode;
import java.util.List;

public class TreeNode2 {
	int val;
	List<TreeNode2> children;
	public TreeNode2(int val) {this.val = val;}
	public TreeNode2(int val, List<TreeNode2> children) {
		this.val = val;
		this.children = children;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(obj instanceof TreeNode2) {
			TreeNode2 treeNode2 = (TreeNode2) obj;
			return this.val == treeNode2.val;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return val * 31;
	}
}
