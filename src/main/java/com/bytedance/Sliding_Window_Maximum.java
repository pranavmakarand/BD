package com.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sliding_Window_Maximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		/*
		 * we will insert into the deque unitil k after k : we need to increment i and j
		 * constantly get the last element of the deque into ans []
		 */

		MonotonicQueue queue = new MonotonicQueue();

		int[] finalAns;

		List<Integer> ans = new ArrayList<Integer>();

		int i = 0, j = 0;

		while (j < nums.length) {
			if (j - i + 1 < k) {
				queue.insertDeque(nums[j], j);
			} else {
				queue.insertDeque(nums[j], j); // common
				ans.add((int) queue.getDequeTail()[0]);
				i++;

				queue.clearDeque(i);
			}
			j++;
		}

		finalAns = new int[ans.size()];

		for (int l = 0; l < ans.size(); l++) {
			finalAns[l] = ans.get(l);
		}

		return finalAns;
	}

	class MonotonicQueue {

		private Deque deque;

		public MonotonicQueue() {
			deque = new ArrayDeque<int[]>();
		}

		public void insertDeque(int num, int index) {
			/*
			 * if the deque is not empty : 1. check if the last element of the deque >
			 * arr[index] If yes : we pop all the elements till the above condition is
			 * satified If No : else : we add the element to the deque
			 */
			while (true) {
				if (!deque.isEmpty()) {
					int[] peekLastArr = (int[]) deque.peekFirst();
					if (peekLastArr[0] < num) {
						deque.pollFirst();
					} else {
						deque.addFirst(new int[] { num, index });
						break;
					}
				} else {
					deque.addFirst(new int[] { num, index });
					break;
				}
			}
		}

		public int[] getDequeTail() {
			return (int[]) deque.peekLast();
		}

		public void clearDeque(int currIndex) {
			int arr[] = (int[]) deque.peekLast();

			while (arr != null && currIndex > arr[1]) {
				deque.pollLast();
				arr = (int[]) deque.peekLast();
			}
		}
	}
}
