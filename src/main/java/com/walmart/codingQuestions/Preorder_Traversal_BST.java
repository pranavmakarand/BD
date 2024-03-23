package com.walmart.codingQuestions;

import java.util.Stack;

public class Preorder_Traversal_BST {
	static int canRepresentBST1(int arr[], int N) { // solution 1 time complexity O(N2)
		boolean leftSide = isValidPreorder(arr, 0, arr.length);
		if (leftSide)
			return 1;
		return 0;
	}

	public static boolean isValidPreorder(int[] preorder, int start, int end) {

		if (start >= end)
			return true;
		// we need to find the current element.
		int current = preorder[start]; // first element
		// we need to find the greater element

		int i = start + 1;

		while (i < end) {
			if (preorder[i] < current)
				i++;
			else
				break;
		}

		int j = i + 1;

		while (j < end) {
			if (preorder[j] < current)
				return false;
			j++;
		}

		boolean one = isValidPreorder(preorder, start + 1, i);

		boolean two = isValidPreorder(preorder, i, end);

		return one && two;
	}

	static int canRepresentBST(int arr[], int N) { //time comnplexity O(N)
		// we iterate the arrs
		// first we set root to -infinity
		// we want to find the smallest element in the array and set it as a root
		// then we want to check if any element is greater than its first greater
		// element
		// If we find that, return it violates the BST principle

		// We first check if there exists something greater than root
		// We check if we have an element greater than peek
		// If yes add stack
		// If no then pop the stack and we have a new root.
		// Add it to the stack

		Stack<Integer> stack = new Stack<Integer>();

		int ref = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (ref > arr[i])
				return 0;

			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				ref = stack.pop();
			}

			stack.add(arr[i]);
		}
		return 1;
	}
}
