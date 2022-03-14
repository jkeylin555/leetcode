package BFS;

import java.util.ArrayDeque;
import java.util.Deque;


public class PrintBinaryTree {
	 private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private void printBinaryTree(TreeNode root) {
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
				TreeNode top = queue.poll();
				System.out.print(top.val);
				if (top.left != null) {
					queue.offer(top.left);
				}
				if (top.right != null) {
					queue.offer(top.right);
				}
			}
        	System.out.println();

		}
	}
	public static void main(String[] args) {
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)),
				new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		root2.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        printBinaryTree.printBinaryTree(root2);

//		Queue<Integer> queue = new ArrayDeque();
//		Deque<Integer> stack = new ArrayDeque<>();
//		queue.offer(1);
//		queue.offer(2);
//		queue.offer(3);
//		queue2.offer(1);
//		queue2.offer(2);
//		queue2.offer(3);
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
	}
}
