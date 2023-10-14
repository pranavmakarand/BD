package com.bytedance;

import java.util.Arrays;
import java.util.Stack;

public class The_Number_Of_Weak_Characters_In_The_Game {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a,b) -> {
        if (a[0] != b[0]) {
            return a[0] - b[0];
        } else if (a[0] == b[0]) {
            return b[1] - a[1];
        }
        return 0;
    });

        Stack deque = new Stack<Integer>();
        int ans = 0;

        for (int i = 0 ; i < properties.length; i++) {
            if (deque.isEmpty()) {
                deque.add(properties[i][1]);
            } else {
                while (true) {
                    if (!deque.isEmpty() && (int)deque.peek() < properties[i][1]) {
                        deque.pop();
                        ++ans;
                    } else {
                        deque.add(properties[i][1]);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
