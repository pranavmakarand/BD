package com.bytedance;

public class Binary_Tree_Max_Path_Sum {

	int globalMax = Integer.MIN_VALUE;

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int maxPathSum(TreeNode root) {
		recursion(root);
		return globalMax;
	}

	private int recursion(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftSubTree = 0;
		int rightSubTree = 0;

		leftSubTree = recursion(root.left);

		if (leftSubTree < 0) {
			leftSubTree = 0;
		}

		rightSubTree = recursion(root.right);

		if (rightSubTree < 0) {
			rightSubTree = 0;
		}

		globalMax = Math.max(leftSubTree + rightSubTree + root.val, globalMax);

		// System.out.println(" Node : " + root.val + " Max : " + globalMax);

		return root.val + Math.max(leftSubTree, rightSubTree);
	}

}
