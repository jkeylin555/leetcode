package Tree;

import BFS.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
	public TreeNode buildTree (int[] preorder, int pre_l, int pre_r, int[] inorder, int in_l, int in_r, Map<Integer, Integer> preToIn){
		if (pre_l > pre_r) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pre_l]);
		int index = preToIn.get(preorder[pre_l]);
		int left_size = index - in_l;

		root.left = buildTree(preorder,pre_l + 1, pre_l + left_size, inorder, in_l, index - 1, preToIn);
		root.right = buildTree(preorder,pre_l + left_size + 1, pre_r, inorder, index + 1, in_r, preToIn);
		return root;
	}
	public static void main(String[] args) {
		ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right= new TreeNode(4);
		root.right.right = new TreeNode(6);

        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
        	map.put(in[i], i);
		}
		TreeNode result = constructBinaryTree.buildTree(pre, 0, 4, in, 0, 4, map);
		System.out.println(result.val);


	}
}
