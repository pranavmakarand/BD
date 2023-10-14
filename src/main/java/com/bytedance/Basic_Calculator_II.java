package com.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

public class Basic_Calculator_II {
	
	public int calculate(String s) {

		Deque<Integer> numStack = new ArrayDeque<Integer>();

		int num = 0;
		char sign = '+';
		s = s.trim();
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				// Convert the ch into the integer.
				int numValue = Integer.parseInt(String.valueOf(ch));
				num = num * 10 + numValue;
			}
			if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) { // for the last allow it to enter
				if (sign == '+') {
					numStack.addFirst(num);
				} else if (sign == '-') {
					numStack.addFirst(-num);
				} else if (sign == '*') {
					int firstPoll = numStack.pollFirst();
					numStack.addFirst(firstPoll * num);
				} else {
					int firstPoll = numStack.pollFirst();
					numStack.addFirst(firstPoll / num);
				}
				sign = ch;
				num = 0;
			}
		}

		while (!numStack.isEmpty()) {
			result += numStack.pollFirst();
		}

		return result;
	}
}
