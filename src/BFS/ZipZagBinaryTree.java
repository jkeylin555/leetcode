package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZipZagBinaryTree {
	private void zipZagBinaryTree (TreeNode root, List<List<Integer>> result) {
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		boolean even = false;

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode;
                if (!even) {
                	treeNode = queue.poll();
				} else {
					treeNode = queue.pollLast();
				}
				list.add(treeNode.val);

				if (even) {
					if (treeNode.right != null) {
						queue.offerFirst(treeNode.right);
					}
					if (treeNode.left != null) {
						queue.offerFirst(treeNode.left);
					}
					} else {
					if (treeNode.left != null) {
						queue.offer(treeNode.left);
					}
					if (treeNode.right != null) {
						queue.offer(treeNode.right);
					}
				}
			}
			result.add(list);
			System.out.println();
			even = !even;
		}
	}

	public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		root2.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        List<List<Integer>> result = new ArrayList<>();
		ZipZagBinaryTree zipZagBinaryTree = new ZipZagBinaryTree();
		zipZagBinaryTree.zipZagBinaryTree(root, result);
		System.out.println(result);
	}
}
