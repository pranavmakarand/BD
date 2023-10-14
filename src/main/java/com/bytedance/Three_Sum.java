package com.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
	public static List<List<Integer>> threeSum(int[] nums) {

		int i = 0;
		int j = 0;
		int k = 0;

		int sum = -1;

		Arrays.sort(nums);

		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		// -2,0,0,2,2
		if (nums.length == 3) {
			i = 0;
			j = i + 1;
			k = j + 1;
			sum = nums[i] + nums[j] + nums[k];
			if (sum == 0) {
				ans.add(List.of(nums[i], nums[j], nums[k]));
				return ans;
			}
		}

		while (i < nums.length - 3) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				i++;
				continue;
			}
			j = i + 1;
			k = nums.length - 1;
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					ans.add(List.of(nums[i], nums[j], nums[k]));
					++j;
					while (nums[j] == nums[j - 1] && j < k) {
						j++;
					}
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
			i++;
		}
		return ans;
	}
}
