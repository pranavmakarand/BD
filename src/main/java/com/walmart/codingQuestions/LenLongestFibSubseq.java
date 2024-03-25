package com.walmart.codingQuestions;

import java.util.HashSet;

public class LenLongestFibSubseq {

	public int lenLongestFibSubseq(int[] arr) { // O(N^2LogM)

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int y = arr[i] + arr[j];
				int x = arr[j];
				int len = 2;
				while (set.contains(y)) {
					int t = y;
					y += x;
					x = t;
					ans = Math.max(++len, ans);
				}
			}
		}

		return ans;
	}

}
