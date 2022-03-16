package BFS;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
//	@Override
//	public boolean equals (Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj instanceof TreeNode) {
//			TreeNode treeNode = (TreeNode) obj;
//			return this.val == treeNode.val;
//		}
//		return false;
//	}
//	@Override
//	public int hashCode() {
//		return val * 31;
//	}

}
