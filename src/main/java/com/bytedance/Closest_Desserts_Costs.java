package com.bytedance;

import java.util.HashSet;

public class Closest_Desserts_Costs {

	private static int diff = Integer.MAX_VALUE;
	static HashSet<Integer> set = new HashSet<Integer>();

	public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

		for (int i = 0; i < baseCosts.length; i++) {
			dp(toppingCosts, target, 0, baseCosts[i], 2);
		}
		
		System.out.println(set);

		if (set.contains(Math.abs(target - diff))) {
			return target - diff;
		} else {
			return target + diff;
		}
	}

	private static void dp(int[] toppingCosts, int target, int n, int amount, int tc) {

		if (n >= toppingCosts.length) {
			set.add(amount);
			diff = Math.min(Math.abs(target - amount), diff);
			return;
		}
		
		if (tc > 0) {
			dp(toppingCosts, target, n, amount + toppingCosts[n], tc-1);
		}
		dp(toppingCosts, target, n + 1, amount, tc);

		return;
	}
	
	public static void main(String args[]) {
		System.out.println(closestCost(new int[] {3,4}, new int[] {1,7}, 10));
	}
}
