package com.bytedance;

import java.util.PriorityQueue;

public class Sort_List {

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

	public ListNode sortList(ListNode head) {

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a, b) -> {
			return a.val - b.val;
		});

		if (head == null) {
			return null;
		}

		ListNode temp = head;

		while (temp != null) {
			queue.add(temp);
			temp = temp.next;
		}

		head = null;
		temp = null;

		while (!queue.isEmpty()) {
			if (head == null) {
				head = new ListNode(queue.poll().val);
				temp = head;
			} else {
				ListNode node = new ListNode(queue.poll().val);
				temp.next = node;
				temp = temp.next;
			}
		}

		return head;
	}
}
