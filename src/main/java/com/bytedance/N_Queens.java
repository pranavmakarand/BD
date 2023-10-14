package com.bytedance;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        List<char[][]> ans = new ArrayList<char[][]>();

        List<String> subList = new ArrayList<String>();
        List<List<String>> finalAns = new ArrayList<List<String>>();

        recursion(0, chess, ans);

        for (char[][] charr : ans) {
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    builder.append(charr[i][j]);
                }
                subList.add(builder.toString());
            }
            finalAns.add(subList);
            subList = new ArrayList<String>();
        }
        return finalAns;
    }

    public char[][] arrcpy(char[][] org) {
        int n = org.length;
        char[][] ans = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               ans[i][j] = org[i][j];
            }
        }
        return ans;
    }

    private void recursion(int j, char[][] chess, List<char[][]> ans) {
        if (j == chess.length) {
            char[][] anss = arrcpy(chess);
            ans.add(anss);
            return;
        }
        for (int f = 0; f < chess.length; f++) {
            if (!queenFinder(chess, f, j)) {
                chess[f][j] = 'Q';
                recursion(j+1, chess, ans);
                chess[f][j] = '.';
            }
        }
    }

    private boolean queenFinder(char[][] matrix, int i, int j) {
        int x = i, y = j;
        boolean flag = false;

        while (x >= 0 && y >= 0) { //diagonal left up
            if (matrix[x][y] == 'Q') {
                flag = true;
                break;
            }
            x--;
            y--;
        }

        if (!flag) {
            x = i; y = j;
            //we need to handle the left horizontal
            while (y >= 0) { //diagonal left check is done
                if (matrix[x][y] == 'Q') {
                    flag = true;
                    break;
                }
                y--;
            }
        }

        if (!flag) {
            x = i; y = j;
            //we need to handle the left horizontal
            while (x <= matrix.length-1 && y >= 0) { //diagonal left down
                if (matrix[x][y] == 'Q') {
                    flag = true;
                    break;
                }
                x++;
                y--;
            }
        }

        if (!flag) {
            x = i; y = j;
            //we need to handle the up vertical
            while (x >= 0) {
                if (matrix[x][y] == 'Q') {
                    flag = true;
                    break;
                }
                x--;
            }
        }

        return flag;
    }
}
