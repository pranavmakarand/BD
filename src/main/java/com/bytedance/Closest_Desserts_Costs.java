package com.bytedance;

import java.util.HashSet;

public class Closest_Desserts_Costs {

	private int diff = Integer.MAX_VALUE;
	HashSet<Integer> set = new HashSet<Integer>();

	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

		for (int i = 0; i < baseCosts.length; i++) {
			dp(toppingCosts, target, 0, baseCosts[i]);
		}

		if (set.contains(Math.abs(target - diff))) {
			return target - diff;
		} else {
			return target + diff;
		}
	}

	private void dp(int[] toppingCosts, int target, int n, int amount) {

		if (n >= toppingCosts.length) {
			set.add(amount);
			diff = Math.min(Math.abs(target - amount), diff);
			return;
		}

		dp(toppingCosts, target, n + 1, amount);
		dp(toppingCosts, target, n + 1, amount + toppingCosts[n]);
		dp(toppingCosts, target, n + 1, amount + (toppingCosts[n] * 2));

		return;
	}
}
