package com.bytedance;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		recursion(candidates, target, 0, 0, list, new ArrayList<Integer>());
		return list;
	}

	private void recursion(int[] candidates, int target, int i, int sum, List<List<Integer>> finalAns,
			List<Integer> temp) {

		if (i == candidates.length) {
			if (target == sum) {
				finalAns.add(new ArrayList<Integer>(temp));
			}
			return;
		}

		if (target == sum) {
			finalAns.add(new ArrayList<Integer>(temp));
			return;
		}

		if (sum <= target) {
			temp.add(candidates[i]);
			recursion(candidates, target, i, sum + candidates[i], finalAns, temp);
			temp.remove(temp.size() - 1);
		}

		recursion(candidates, target, i + 1, sum, finalAns, temp);

		return;
	}
}
