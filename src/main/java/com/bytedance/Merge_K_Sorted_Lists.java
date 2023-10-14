package com.bytedance;

import java.util.PriorityQueue;

public class Merge_K_Sorted_Lists {

	public class ListNode {
		
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		// iterate throught the list of Nodes
		// add them to the queue
		// create a new linklist and add the elements of the queue to the list

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> a - b);

		for (ListNode node : lists) {
			ListNode temp = node;
			while (temp != null) {
				queue.add(temp.val);
				temp = temp.next;
			}
		}

		ListNode head = null;

		ListNode temp = head;

		while (!queue.isEmpty()) {
			if (head == null) {
				head = new ListNode(queue.poll());
			} else {
				ListNode newNode = new ListNode(queue.poll());
				if (head.next == null) {
					head.next = newNode;
					temp = head.next;
				} else {
					temp.next = newNode;
					temp = temp.next;
				}
			}
		}

		return head;
	}
}
