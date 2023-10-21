package com.ZipRecuiter.OA;

import java.util.Arrays;

public class question_2 {
	
    public int[] sol(int[] wins, int[] draws, int[] scored, int[] conceded) {
        int n = wins.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = wins[i] * 3 + draws[i];
        }

        int[] tiebreakers = new int[n];
        for (int i = 0; i < n; i++) {
            tiebreakers[i] = scored[i] - conceded[i];
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on points and tiebreakers
        Arrays.sort(indices, (a, b) -> {
            if (arr[a] == arr[b]) {
                return tiebreakers[b] - tiebreakers[a];
            }
            return arr[b] - arr[a];
        });

        int[] result = {indices[0], indices[1]};

        return result;
    }

    public static void main(String[] args) {
        question_2 question2 = new question_2();

        int[] wins = {3, 3, 3};
        int[] draws = {3, 3, 3};
        int[] scored = {8, 8, 8};
        int[] conceded = {8, 8, 8};

        int[] result = question2.sol(wins, draws, scored, conceded);
        System.out.println("First place: " + result[0] + ", Second place: " + result[1]);
    }
}
