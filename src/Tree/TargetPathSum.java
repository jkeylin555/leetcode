package Tree;

import BFS.TreeNode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TargetPathSum {
	public void pathTarge(TreeNode root, int target, int prefix, Set<Integer> set, int t) {

		int cur = prefix + root.val;
		set.add(cur);
		if (set.contains(cur - target)) {
			t = 10000;
		}
		if (root.left != null) {
			pathTarge(root.left, target, cur, set, t);
		}
		if (root.right != null) {
			pathTarge(root.right, target, cur, set, t);
		}

	}

    static boolean result = false;
	public void pathTarge2(TreeNode root, int target, int prefix, Set<Integer> set) {

		int cur = prefix + root.val;
		set.add(cur);
		if (set.contains(cur - target)) {
			result = true;
		}
		if (root.left != null) {
			pathTarge2(root.left, target, cur, set);
		}
		if (root.right != null) {
			pathTarge2(root.right, target, cur, set);
		}

	}


//	public void pathTarge3(TreeNode root, int target, int prefix, Set<Integer> set) {
//
//		int cur = prefix + root.val;
//		set.add(cur);
//		if (set.contains(cur - target)) {
//			result = true;
//		}
//		if (root.left != null) {
//			pathTarge2(root.left, target, cur, set);
//		}
//		if (root.right != null) {
//			pathTarge2(root.right, target, cur, set);
//		}
//
//	}
	public static void main(String[] args) {
		TargetPathSum targetPathSum = new TargetPathSum();
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		Set<Integer> set = new HashSet<>();
		set.add(0);
		boolean res = false;
		int t = -10000;
		targetPathSum.pathTarge2(root, 10,0, set);
		System.out.println(result);
	}


}
