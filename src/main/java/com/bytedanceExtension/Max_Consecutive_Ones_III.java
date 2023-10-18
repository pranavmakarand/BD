package com.bytedanceExtension;

public class Max_Consecutive_Ones_III {

	public int longestOnes(int[] nums, int k) {
		// first
		int i = 0;
		int j = 0;
		int c = 0;
		int max = 0;

		while (j < nums.length) {
			if (nums[j] == 0) {
				++c;
			}
			if (c <= k) {
				max = Math.max(max, j - i + 1);
			} else {
				while (i < nums.length && c > k) {
					if (nums[i++] == 0) {
						--c;
					}
				}
			}
			j++;
		}
		return max;
	}
}
