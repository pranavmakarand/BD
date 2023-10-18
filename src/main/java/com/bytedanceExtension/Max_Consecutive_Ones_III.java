package com.bytedanceExtension;

public class Max_Consecutive_Ones_III {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				max = Math.max(counter, max);
				counter = 0;
			} else if (i == nums.length - 1) {
				counter++;
				max = Math.max(counter, max);
			} else {
				counter++;
			}
		}
		return max;
	}
}
