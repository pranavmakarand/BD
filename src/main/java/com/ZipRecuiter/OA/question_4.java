package com.ZipRecuiter.OA;

import java.util.ArrayList;
import java.util.List;

public class question_4 {
    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 7});
        intervals.add(new int[]{5, 11});
        intervals.add(new int[]{7, 9});

        List<Integer> nums = new ArrayList<>();
        nums.add(7);
        nums.add(1);
        nums.add(5);
        nums.add(10);
        nums.add(9);
        nums.add(15);

        List<Integer> result = countCheck2(intervals, nums);
        System.out.println(result); // Output: [3, 1, 2, 1, 2, 0]
    }

    public static List<Integer> countCheck2(List<int[]> intervals, List<Integer> nums) {
        final int MAX_VAL = 100000; // Adjust this value based on the maximum possible interval end value
        int[] freq = new int[MAX_VAL];

        int min_val = Integer.MAX_VALUE;
        int max_val = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            int li = interval[0];
            freq[li]++;
            int ri = interval[1];
            freq[ri + 1]--;

            if (li < min_val) {
                min_val = li;
            }
            if (ri > max_val) {
                max_val = ri;
            }
        }

        for (int i = min_val + 1; i <= max_val; i++) {
            freq[i] += freq[i - 1];
        }

        List<Integer> result = new ArrayList<>();
        for (int v : nums) {
            if (v >= min_val && v <= max_val) {
                result.add(freq[v]);
            } else {
                result.add(0);
            }
        }

        return result;
    }
}
