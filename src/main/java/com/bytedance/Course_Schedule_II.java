package com.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_II {
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[][] matrix = new int[numCourses][numCourses];

		for (int i = 0; i < prerequisites.length; i++) {

			int startVertex = prerequisites[i][0];
			int endVertex = prerequisites[i][1];

			matrix[startVertex][endVertex] = 1;
		}

		int inBound[] = new int[numCourses];
		int sum = 0;

		for (int i = 0; i < matrix.length; i++) {

			sum = 0;

			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[j][i] == 1) {
					sum += matrix[j][i];
				}
			}

			inBound[i] = sum;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		List<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < inBound.length; i++) {
			if (inBound[i] == 0) {
				queue.add(i);
			}
		}

		if (queue.isEmpty()) {
			return new int[] {};
		}

		while (!queue.isEmpty()) {

			int vertex = queue.poll();
			ans.add(vertex);

			List<Integer> outBounds = new ArrayList<Integer>();

			for (int i = 0; i < numCourses; i++) {
				if (matrix[vertex][i] == 1) {
					outBounds.add(i);
				}
			}

			for (int outV : outBounds) {
				if (inBound[outV] > 0) {
					--inBound[outV];
				}
				if (inBound[outV] == 0) {
					queue.add(outV);
				}
			}
		}

		if (ans.size() < numCourses) {
			return new int[] {};
		}

		int[] arr = new int[ans.size()];

		int c = arr.length - 1;

		for (int a : ans) {
			arr[c] = a;
			c--;
		}

		return arr;
	}
}
